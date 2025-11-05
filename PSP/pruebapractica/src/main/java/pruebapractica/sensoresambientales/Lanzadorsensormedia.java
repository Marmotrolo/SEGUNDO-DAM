package pruebapractica.sensoresambientales;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lanzadorsensormedia {
	private static final String rutaFicheroJava = "src\\main\\java\\pruebapractica\\sensoresambientales\\GestionSensormedia.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	//private static final String NOMBRE_CLASE_HIJA = "tema1.Boletin2.Temperaturas.AnalizadorTemperaturas";

	public static void main(String[] args) {
		
		Lanzadorsensormedia lanzadorsensormedia = new Lanzadorsensormedia();
		
		String[] sensoresambientales = {"TEMPERATURA","HUMEDAD","PRESION"};
		String fihcerosensores = "src/main/resources/lecturas.txt";
		
		lanzadorsensormedia.compilaProceso();
	    System.out.println("--PROCESO PADRE: Resumen Resultados--");

		for (String sensoritero : sensoresambientales) {
			//busque para convertir int a String y poder usarlo en la funcion

			lanzadorsensormedia.ejecutaProceso(fihcerosensores, sensoritero) ;
			
		}
		
	}
	
	public void compilaProceso() {
		String[] comando = { "javac", "-d",directorioGenerarClases ,rutaFicheroJava};
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

	public void ejecutaProceso(String ruta, String sensor) {
		int numero=0;

	

		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava, sensor,"src\\main\\resources\\lecturas.txt"};




		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			//pb.redirectErrorStream(true);
			//pb.inheritIO();
			Process p1 = pb.start();
			BufferedReader reader= new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			 String linea = reader.readLine();
	            System.out.println( linea);
	            
	           

			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();

	}
		
	
	}
	}
	