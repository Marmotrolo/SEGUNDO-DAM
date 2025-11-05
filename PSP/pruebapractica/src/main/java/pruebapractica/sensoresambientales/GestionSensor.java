package pruebapractica.sensoresambientales;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestionSensor {
	private static final String rutasalida= "src/main/resources/";

	public static void main(String[] args) {
		GestionSensor f = new GestionSensor();

	//	String rutaficheroprovincias= args[2];
		String variableambiental= args[0];
	//	String rutaficherocreacion= args[1];
		String rutalecturas= args[1];
        String ficheroSalida = rutasalida + variableambiental + ".txt";

		try {
			List<String> listavariableambientales= f.contarprovinciasamazon( rutalecturas,  variableambiental);
			f.crearficheroresultado(listavariableambientales, ficheroSalida );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> contarprovinciasamazon(String rutalecturas, String variableambiental) throws FileNotFoundException {
		int contador=0;
		List<String> variablesambientales = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(rutalecturas))) {
            while (in.hasNextLine()) {
                String linea = in.nextLine().trim();

                String[] partes = linea.split(";");
                    String variableambientalitero = partes[0].trim();
                    if (variableambientalitero.equalsIgnoreCase(variableambiental)) {
                    	variablesambientales.add(linea);
                        contador++;
                    }
                }
            }
        
        //System.out.println(variableambiental + ":" + contador );

        return variablesambientales;
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
