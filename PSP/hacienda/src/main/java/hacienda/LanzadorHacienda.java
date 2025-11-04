package hacienda;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class LanzadorHacienda {
	private static final String rutaFicheroJava = "src\\main\\java\\hacienda\\GenerarDNISFichero.java" ;
	private static final String rutaFicheroJava2 = "src\\main\\java\\hacienda\\GenerarNSSSFichero.java" ;

	private static final String directorioGenerarClases = "target\\classes";
	//private static final String NOMBRE_CLASE_HIJA = "tema1.Boletin2.Temperaturas.AnalizadorTemperaturas";

	public static void main(String[] args) {
		
		LanzadorHacienda lanzadordatos = new LanzadorHacienda();
		
		List<String> rutasficherosjava= new ArrayList<>();
		rutasficherosjava.add(rutaFicheroJava);
		rutasficherosjava.add(rutaFicheroJava2);
		String fihcerodatos= "src/main/resources/datos.txt";
		
		lanzadordatos.compilaProceso(rutaFicheroJava);
		lanzadordatos.compilaProceso(rutaFicheroJava2);

		int dnis= lanzadordatos.ejecutaProceso("hacienda.GenerarDNISFichero");
		int nsses= lanzadordatos.ejecutaProceso("hacienda.GenerarNSSSFichero");
	
		
		try {
			lanzadordatos.guardarresumen(dnis, nsses);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void compilaProceso(String ruta) {
		String[] comando = { "javac", "-d",directorioGenerarClases ,ruta};

		
		ProcessBuilder pb = new ProcessBuilder(comando);

		
		try {
			// para la comunicacion entre proceso padre e hijo
			pb.redirectErrorStream(true);
			pb.inheritIO();

			Process p1 = pb.start();

			int exit = p1.waitFor();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int ejecutaProceso(String ruta) {
		int numero=0;

		String[] comando1 = {"java", "-cp", directorioGenerarClases,ruta};

		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			//pb.redirectErrorStream(true);
			//pb.inheritIO();
			Process p1 = pb.start();
			BufferedReader reader= new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));
			 String linea = reader.readLine();
	           while (linea != null) {
	            System.out.println( linea);
	               
	   			String[] porpuntos = linea.split(":");

	            linea = reader.readLine();     

			
			numero= Integer.parseInt(porpuntos[1]);
	           }	   			
			
	           

			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();

	}
		return numero;
	}
	
	public void guardarresumen(int dnis, int nsses) throws IOException {
		   PrintWriter out = null;
	        try {
	            FileWriter ficheroSalida = new FileWriter("src/main/resources/resumen.txt");
	            out = new PrintWriter(ficheroSalida);

				out.println("Número total de contribuyentes:" );
				out.println("DNIS: " + dnis);
				out.println("NSSES: " + nsses);

			

	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	        
	
	}
}
