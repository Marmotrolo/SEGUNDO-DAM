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
import xml.modelo.Producto;

public class XMLdomEmpleados {
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
		private  Empleado getEmpleadoFromElement(Element elemento){
			Empleado e = new Empleado();
			String nombre = elemento.getElementsByTagName("nombreApellido").item(0).getTextContent();
			int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
			String empresa = elemento.getElementsByTagName("empresa").item(0).getTextContent();
			String id = elemento.getAttribute("identificador"); 
			e.setEdad(edad);
			e.setNombreApellido(nombre);
			e.setId(id);
			e.setEmpresa(empresa);
			return e;
	}

		public List<Empleado> leerEmpleadosDesdeXML(String rutaFichero) throws Exception {
			List<Empleado> empleados = new ArrayList<Empleado>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosEmpleados = doc.getElementsByTagName("empleado");
	 // 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosEmpleados.getLength(); j++) {
				Node modeloNodo = nodosEmpleados.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Empleado e = this.getEmpleadoFromElement((Element) modeloNodo);
					empleados.add(e);
				}
			}
			return empleados;
		}

}
