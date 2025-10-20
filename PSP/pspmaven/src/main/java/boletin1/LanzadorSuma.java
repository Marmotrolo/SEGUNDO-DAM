package boletin1;

import java.io.IOException;

public class LanzadorSuma {
	String tipo="par";
	int numero=10;
public static void main(String[] args) {
	LanzadorSuma lanzador= new LanzadorSuma();
	lanzador.ejecutaProceso("par","10");
	lanzador.ejecutaProceso("impar","10");
	
}

private static final String directorioGenerarClases = "target\\classes" ;

private static final String rutaFicheroJava = "src\\main\\java\\boletin1\\Calculasuma.java";
public void ejecutaProcesoCompila() {

	String[] comando = { "javac", "-d", directorioGenerarClases, 
			rutaFicheroJava + "Gestiona.java"};
	ProcessBuilder pb = new ProcessBuilder(comando);
	
	try {
		pb.redirectErrorStream(true);
		pb.inheritIO();
		Process p1 = pb.start();

	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void ejecutaProceso(String tipo, String numero) {

	String[] comando2 = {"java", "-cp", directorioGenerarClases, rutaFicheroJava,  tipo, numero };
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
