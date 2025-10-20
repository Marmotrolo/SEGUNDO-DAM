package tema1.Boletin2.Ejercicio10;

import java.io.IOException;

public class LanzadorPython {

	private static final String rutaFicheroJava = "src\\main\\resources\\fichero.py";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LanzadorPython lanzador = new LanzadorPython();
		lanzador.ejecutaProceso();

	}

	public void ejecutaProceso()   {

		String[] comando = {"python", rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			
	
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
}
