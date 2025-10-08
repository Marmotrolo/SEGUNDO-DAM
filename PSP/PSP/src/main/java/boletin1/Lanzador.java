package boletin1;

import java.io.IOException;

public class Lanzador {
	private static final String rutaFicherosJava= "C:\\Users\\ManuelParrado\\Desktop\\SEGUNDO_DAM\\PSP\\PSP\\src\\main\\java";

	private static final String directorioGenerarClasses= "C:\\Users\\ManuelParrado\\Desktop\\SEGUNDO_DAM\\PSP\\PSP\\target";
	public static void main(String[] args) {
		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaFicherosJava + "\boletin1\\Gestiona.java" };
		
	ProcessBuilder pb = new ProcessBuilder (comando);
	pb.redirectErrorStream(true);
	
	try {
		Process proceso1= pb.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void ejecutaproceso() {
		String[] comando = {"java", "-cp", "target/classes", rutaFicherosJava + "C:\\Users\\ManuelParrado\\Desktop\\SEGUNDO_DAM\\PSP\\PSP\\src\\main\\java\\boletin1\\Gestiona.java"};
	}
}
