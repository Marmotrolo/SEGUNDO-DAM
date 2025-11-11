package util;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.CentroLogistico;
import modelo.Trabajador;

public class XMLDomBancoAlimento {
	private static final Logger logger= LogManager.getLogger(XMLDomBancoAlimento.class);
		
		private static final String rutaFichero= "src\\main\\resources\\";
	
		//siempre igual
			//genero dom
			private Document getDocumentFromXML(String nombrefichero) {
				File file = new File(rutaFichero + nombrefichero);
				Document documento = null;
				try {
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					documento = dBuilder.parse(file);
	
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				return documento;
				
				
			} 
			//cambia dependiendo de lo que quiera
			 private CentroLogistico getCentroLogisticoFromElement(Element elemento) {
			        CentroLogistico centro = new CentroLogistico();
			        centro.setId(elemento.getElementsByTagName("ID").item(0).getTextContent().trim());
			        centro.setNombre(elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim());
			        centro.setCiudad(elemento.getElementsByTagName("Ciudad").item(0).getTextContent().trim());
			        centro.setNumeroComedores(Integer.parseInt(
			                elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent().trim()));
					return centro;
			 }
			
			 private Trabajador getTrabajadorFromElement(Element elemento, String idCentro) {
			        Trabajador t = new Trabajador();
			        t.setNombre(elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim());
			        t.setDni(elemento.getElementsByTagName("DNI").item(0).getTextContent().trim());
			        t.setFechaNacimiento(LocalDate.parse(elemento.getElementsByTagName("FechaNacimiento").item(0).getTextContent().trim()));
			        String tipo = elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim();
			        t.setEsAsalariado(tipo.equalsIgnoreCase("Asalariado"));
			        return t;
			    }
	
			public List<CentroLogistico> leerCentroLogisticosDesdeXML(String rutaFichero) throws Exception {
				List<CentroLogistico> productos = new ArrayList<CentroLogistico>();
				// 1. Calcula el dom
				Document doc = getDocumentFromXML(rutaFichero);
				// 2. Obtener todos los nodos con etiqueta empleados
				NodeList nodosproductos = doc.getElementsByTagName("Producto");
		 // 3. Recorro la lista de los nodos empleado
				for (int j = 0; j < nodosproductos.getLength(); j++) {
					Node modeloNodo = nodosproductos.item(j);
					if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
						CentroLogistico e = this.getCentroLogisticoFromElement((Element) modeloNodo);
						productos.add(e);
					}
				}
				return productos;
			}	
	}

