package Multiplicar;


import java.io.IOException;

import Multiplicar.Contarpalabras;

public class LanzadorContarPalabras{
	String tipo="par";
	int numero=10;
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

	} catch (IOException e) {
		e.printStackTrace();
	
}
}
}

