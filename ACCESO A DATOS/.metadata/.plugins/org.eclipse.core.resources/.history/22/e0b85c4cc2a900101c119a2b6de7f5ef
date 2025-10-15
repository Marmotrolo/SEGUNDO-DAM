package fichero;



import java.io.FileNotFoundException;

import java.io.FileReader;

import java.util.Scanner;



import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;



public class OperacionesStream {



	private static final Logger logger = LogManager.getLogger(OperacionesStream.class);



	public static void main(String[] args) {



		OperacionesStream l = new OperacionesStream();

		try {

			l.muestraContenidoFich("C:\\Users\\ManuelParrado\\Desktop\\SEGUNDO_DAM\\ACCESO A DATOS\\accesoDatos\\src\\main\\resources\\carpetita\\luis.txt");

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block

			logger.debug(e.getMessage());

		}

	}



	void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {

		Scanner in = null;

		try {

			// abre el fichero

			FileReader fichero = new FileReader(rutaYNombre);

			// Se crea el flujo

			in = new Scanner(fichero);

			// lee el fichero

			while (in.hasNext()) { // Lectura palabra a palabra

				// Aquí se hará la lectura in.next()

				String palabra = in.next();

				logger.info("Palabra: " + palabra);	

			}

		} finally {

			if (in != null) {

				in.close();

			}

		}

	}

}
