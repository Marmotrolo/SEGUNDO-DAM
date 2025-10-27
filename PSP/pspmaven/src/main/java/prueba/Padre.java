package prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Padre {
	String tipo="par";
	int numero=10;
public static void main(String[] args) {
	
	Padre lanzador= new Padre();
	lanzador.ejecutaProcesoCompila();
	lanzador.ejecutaProceso(directorioGenerarClases, rutaFicheroJava);

	
}

private static final String directorioGenerarClases = "target\\classes" ;

private static final String rutaFicheroJava = "src/main/java/prueba/Hijo.java";
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

	String[] comando2 = {"java", "-cp", directorioGenerarClases, rutaFicheroJava, };
	ProcessBuilder pb = new ProcessBuilder(comando2);
	
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process p1 = pb.start();
		BufferedReader buffer= new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String linea=buffer.readLine();
		while(linea!=null) {
			System.out.println("padre" + linea);
			linea= buffer.readLine();
		}
	} catch (IOException e) {
		e.printStackTrace();
	
}
}
}

