package utiles;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import pruebaJSON.Empleado;

public class leerjson {

	
		

		private static final Logger logger = LogManager.getLogger(leerjson.class);

		
		public void leeEmpleados(String rutaFichero) {
			try {
			  Gson gson = new Gson();
			  FileReader fichero = new FileReader(rutaFichero);
			  // Leer el archivo JSON y convertirlo a un objeto Empleado
			  Empleado[] empleadosArray = gson.fromJson(fichero,Empleado[].class);
				List<Empleado> empleados = Arrays.asList(empleadosArray);
				logger.info(empleados);
			} catch (Exception e) {
				logger.debug("Error al leer empleados"+e.getMessage());
			}	}

	
}
