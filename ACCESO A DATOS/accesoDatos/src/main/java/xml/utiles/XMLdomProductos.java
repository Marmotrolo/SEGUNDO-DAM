package xml.utiles;

import java.io.File;
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

import xml.modelo.Producto;

public class XMLdomProductos {
private static final Logger logger= LogManager.getLogger(XMLdomEmpleado.class);
	
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
		private  Producto getProductoFromElement(Element elemento){
				Producto e = new Producto();
				String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
				int stock = Integer.parseInt(elemento.getElementsByTagName("Stock").item(0).getTextContent().trim());
				double precio = Double.parseDouble(elemento.getElementsByTagName("Precio").item(0).getTextContent().trim()) ;
				boolean enventa= Boolean.parseBoolean(elemento.getAttribute("aLaVenta").trim());
				int id =  Integer.parseInt(elemento.getAttribute("id").trim()); // La etiqueta empleado tiene el atributo identificador
				e.setNombre(nombre);
				e.setEnventa(enventa);
				e.setStock(stock);
				e.setId(id);
				e.setPrecio(precio);
				return e;
		}

		public List<Producto> leerpodructosDesdeXML(String rutaFichero) throws Exception {
			List<Producto> productos = new ArrayList<Producto>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosproductos = doc.getElementsByTagName("Producto");
	 // 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosproductos.getLength(); j++) {
				Node modeloNodo = nodosproductos.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Producto e = this.getProductoFromElement((Element) modeloNodo);
					productos.add(e);
				}
			}
			return productos;
		}	
}
