package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//papa
public class AnalizadorProvincias {
	
	private static final String rutaFicheroJava = "src\\main\\java\\amazon\\ExtractorPedidosProvincia.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	//private static final String NOMBRE_CLASE_HIJA = "tema1.Boletin2.Temperaturas.AnalizadorTemperaturas";

	public static void main(String[] args) {
		
		AnalizadorProvincias lanzadorTemp = new AnalizadorProvincias();
		
		String[] provincias = {"Sevilla","Málaga","Jaén","Cádiz","Almería","Huelva","Granada","Córdoba"};
		String fihceroprovincias = "src/main/resources/pedidos.txt";
		
		lanzadorTemp.compilaProceso();
		int totalpedidos=0;
		for (String nomprovincia : provincias) {
			//busque para convertir int a String y poder usarlo en la funcion
			totalpedidos = totalpedidos + lanzadorTemp.ejecutaProceso(fihceroprovincias, nomprovincia) ;
			
		}
		System.out.println("Total pedidos:" + totalpedidos );
		
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

	public int ejecutaProceso(String ruta, String prov) {
		int numero=0;

		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,prov};

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
}