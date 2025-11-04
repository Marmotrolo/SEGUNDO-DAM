package xml.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.modelo.Empleado;
import xml.utiles.XMLdomEmpleado;
import xml.utiles.XMLdomEmpleados;

public class Main {
	private static final Logger logger= LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		XMLdomEmpleados xmlempleado= new XMLdomEmpleados();
		
		try {
			List<Empleado> empleado = xmlempleado.leerEmpleadosDesdeXML("empleados.xml");
			logger.info(empleado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
