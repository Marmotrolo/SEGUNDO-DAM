package xml.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.modelo.Empleado;
import xml.modelo.Pelicula;
import xml.utiles.XMLdomEmpleados;
import xml.utiles.XMLdomPeliculas;

public class MainPelicula {
	private static final Logger logger= LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		XMLdomPeliculas XMLdomPeliculas= new XMLdomPeliculas();
		
		try {
			List<Pelicula> empleado = XMLdomPeliculas.leerPeliculasDesdeXML("peliculas.xml");
			logger.info(empleado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


