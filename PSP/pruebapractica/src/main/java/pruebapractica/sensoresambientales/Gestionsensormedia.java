package pruebapractica.sensoresambientales;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestionsensormedia {
	private static final String rutasalida= "src/main/resources/";

	public static void main(String[] args) {
		Gestionsensormedia f = new Gestionsensormedia();

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
		double contadormedia=0;
		double datosambientales=0;
		List<String> variablesambientales = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(rutalecturas))) {
            while (in.hasNextLine()) {
                String linea = in.nextLine().trim();

                String[] partes = linea.split(";");
                    String variableambientalitero = partes[0].trim();
                    if (variableambientalitero.equalsIgnoreCase(variableambiental)) {
                        contadormedia= contadormedia + Double.parseDouble(partes[1]);

                    	variablesambientales.add(linea);
                        contador++;
                    }
                   
                    
                }
            }
        double media= contadormedia/contador ;

        
        System.out.println(variableambiental + ":Numero de Registros: " + contador + ", media:" + media );

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
