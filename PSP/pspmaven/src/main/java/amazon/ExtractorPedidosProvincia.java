package amazon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ExtractorPedidosProvincia {
	private static final String rutaprovincias= "src/main/resources/";

	public static void main(String[] args) {
		ExtractorPedidosProvincia f = new ExtractorPedidosProvincia();

	//	String rutaficheroprovincias= args[2];
		String provincia= args[0];
	//	String rutaficherocreacion= args[1];
        String ficheroSalida = rutaprovincias + provincia + ".txt";

		try {
			List<String> listaprovincias= f.contadortemperaturassuperiores( rutaprovincias+"/pedidos.txt",  provincia);
			f.crearficheroresultado(listaprovincias, ficheroSalida );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> contadortemperaturassuperiores(String rutaficheroprovincias, String provincia) throws FileNotFoundException {
		int contador=0;
		List<String> pedidos = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(rutaficheroprovincias))) {
            while (in.hasNextLine()) {
                String linea = in.nextLine().trim();

                String[] partes = linea.split("#");
                    String prov = partes[5].trim();
                    if (prov.equalsIgnoreCase(provincia)) {
                        pedidos.add(linea);
                        contador++;
                    }
                }
            }
        
        System.out.println(provincia + ":" + contador );

        return pedidos;
}
    
	
	
	public void crearficheroresultado (List <String> provincias, String rutaFicheroSalida) throws IOException {
		//List<String> listaprovincias = contadortemperaturassuperiores(rutaficheroprovincias, provincia);
	        PrintWriter out = null;
	        try {
	            FileWriter ficheroSalida = new FileWriter(rutaFicheroSalida);
	            out = new PrintWriter(ficheroSalida);
	            out.println(provincias.size());
	           for (String string : provincias) {
				out.println(string);
			};

	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	}
	}
	

