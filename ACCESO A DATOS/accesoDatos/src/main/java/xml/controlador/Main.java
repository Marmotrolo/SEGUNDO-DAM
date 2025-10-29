package xml.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.Empleado;
import xml.XMLdomEmpleado;

public class Main {
	private static final Logger logger= LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		XMLdomEmpleado xmlempleado= new XMLdomEmpleado();
		
		try {
			Empleado empleado = xmlempleado.leerEmpleadoDesdeXML("empleado.xml");
			logger.info(empleado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
