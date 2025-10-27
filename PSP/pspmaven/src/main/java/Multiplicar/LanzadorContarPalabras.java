package Multiplicar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Multiplicar.Contarpalabras;

public class LanzadorContarPalabras{
public static void main(String[] args) {
	LanzadorContarPalabras lanzador= new LanzadorContarPalabras();
	lanzador.ejecutaProcesoCompila();
	lanzador.ejecutaProceso("es","fichero.txt");
	lanzador.ejecutaProceso("Java","fichero.txt");
	lanzador.ejecutaProceso("y","fichero.txt");

	
}

private static final String directorioGenerarClases = "target\\classes" ;

private static final String rutaFicheroJava = "src/main/java/Multiplicar/Contarpalabras.java";
public void ejecutaProcesoCompila() {

	String[] comando = { "javac", "-d", directorioGenerarClases, 
			rutaFicheroJava };
	ProcessBuilder pb = new ProcessBuilder(comando);
	
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process p1 = pb.start();

	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void ejecutaProceso(String palabra, String ruta) {

	String[] comando2 = {"java", "-cp", directorioGenerarClases, rutaFicheroJava,  palabra, ruta};
	ProcessBuilder pb = new ProcessBuilder(comando2);
	
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process p1 = pb.start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

		int exit = p1.waitFor();
		System.out.println(exit);

		if (exit != 0) {
			String errorLinea = errorReader.readLine();
			while (errorLinea != null) {
				System.err.println("Error Padre: " + errorLinea);
				errorLinea = errorReader.readLine();
			}
		} else {
			String linea = reader.readLine();

			while (linea != null) {
				System.out.println("Padre: " + linea);
				linea = reader.readLine();
			}

		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}

