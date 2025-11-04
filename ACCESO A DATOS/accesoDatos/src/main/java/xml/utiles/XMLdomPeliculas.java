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

import xml.modelo.Empleado;
import xml.modelo.Pelicula;

public class XMLdomPeliculas {
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
		private  Pelicula getPeliculaFromElement(Element elemento){
			Pelicula e = new Pelicula();
				String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
				int fecha = Integer.parseInt(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
				String director = elemento.getElementsByTagName("Director").item(0).getTextContent();

				e.setTitulopelicula(titulo);;
				e.setAño(fecha);;
				e.setDirector(director);
				Node p = elemento.getElementsByTagName("Actores").item(0);
				if(p !=null && p.getNodeType() == Node.ELEMENT_NODE) {
				e.setActores(this.getActoresFromElement((Element)p));
				}
				return e;
		}
		
		private List<String> getActoresFromElement(Element elemento){
			List<String>actores= new ArrayList<String>();
			NodeList actornodo = elemento.getElementsByTagName("Actor");
			 // 3. Recorro la lista de los nodos empleado
					for (int j = 0; j < actornodo.getLength(); j++) {
						Node modeloNodo = actornodo.item(j);
						if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
							Element hijo= (Element) modeloNodo;
							
							 
							actores.add(hijo.getFirstChild().getNodeValue());
						}
						}
			
			return actores;
			
		}
		public List<Pelicula> leerPeliculasDesdeXML(String rutaFichero) throws Exception {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosPeliculas = doc.getElementsByTagName("Pelicula");
	 // 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosPeliculas.getLength(); j++) {
				Node modeloNodo = nodosPeliculas.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Pelicula e = this.getPeliculaFromElement((Element) modeloNodo);
					peliculas.add(e);
				}
			}
			return peliculas;
		}

}
