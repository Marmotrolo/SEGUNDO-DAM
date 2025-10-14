package fichero;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio2 {

	private static final Logger logeador = LogManager.getLogger(Ejercicio2.class);
	
	public static void main(String[] args) {
		
		String cagarruta=  "C:\\Users\\manue\\OneDrive\\Desktop\\Ficheros java";
		File directorio= new File (cagarruta);
		File fichero= new File (directorio, "ola.txt");
		
		try {
			boolean creado= fichero.createNewFile();
			logeador.info(fichero.getName());       
			logeador.info(fichero.getPath());
			logeador.info(fichero.canRead());
			logeador.info(fichero.getAbsolutePath());	
			logeador.info(fichero.getParent());
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
