package util;

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

import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Videojuego;
import repositorio.RepoEquipo;

public class XMLDomTorneo {
	private static final Logger logger = LogManager.getLogger(XMLDomTorneo.class);
	private static final String rutaResources = "src\\main\\resources\\";
	private RepoEquipo repositorioequipo=  new RepoEquipo();
	// este siempre es igual para todos
	// para generar el dom del xml
	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
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
	
	// primero leemos piloto y creamos el árbol con su lista
	// porque no pertence directamente al equipo cada uno por su lado
	
	private Equipo getEquipoFromElement(Element elemento)
	{
		Equipo e = new Equipo();
			String codigo = (elemento.getAttribute("codigo"));
			String nombreequipo = elemento.getElementsByTagName("nombre").item(0).getTextContent();
		    String email = elemento.getElementsByTagName("email").item(0).getTextContent();
		    int nunjugadores = Integer.parseInt(elemento.getElementsByTagName("numJugadores").item(0).getTextContent());
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			e.setId(codigo);
			e.setNombre(nombreequipo);
			e.setEmailcontacto(email);
			e.setNumjugadores(nunjugadores);
		
			
			return e;
		}
	
	public List<Equipo> leerEquiposDesdeXML(String rutaFichero) throws Exception {
		List<Equipo> pilotos = new ArrayList<Equipo>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("equipo");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Equipo p = this.getEquipoFromElement((Element) modeloNodo);
				pilotos.add(p);
			}
		}
		return pilotos;
	}
	
	// lo mismo pero con equipos
	
	private Enfrentamiento getEnfrentamientoFromElement(Element elemento)
	{
		Enfrentamiento enfrenetamiento = new Enfrentamiento();
			int identificadorenfrenetamiento = Integer.parseInt(elemento.getAttribute("id"));
			String fecha = elemento.getElementsByTagName("fecha").item(0).getTextContent();
			String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
			Videojuego videojuego= Videojuego.valueOf(elemento.getElementsByTagName("videojuego").item(0).getTextContent()); 
		    String equipoganador=  elemento.getElementsByTagName("ganador").item(0).getTextContent();
		    
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			enfrenetamiento.setId(identificadorenfrenetamiento);
			enfrenetamiento.setFecha(fecha);
			enfrenetamiento.setDescripcionevento(descripcion);
			enfrenetamiento.setVideojuego(videojuego);
			enfrenetamiento.setEquipoganador(equipoganador);
			
			
			return enfrenetamiento;
		}
	
	public List<Enfrentamiento> leerEnfrentamientosDesdeXML(String rutaFichero) throws Exception {
		List<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("enfrentamiento");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Enfrentamiento e = this.getEnfrentamientoFromElement((Element) modeloNodo);
				enfrentamientos.add(e);
			}
		}
		return enfrentamientos;
	}

}
