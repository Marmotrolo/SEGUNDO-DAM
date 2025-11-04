package hacienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerarDNISFichero {
	private static final String rutadatos= "src/main/resources/";

	public static void main(String[] args) {
		GenerarDNISFichero f = new GenerarDNISFichero();

	//	String rutaficheroprovincias= args[2];
	//	String rutaficherocreacion= args[1];
        String ficheroSalida = rutadatos +  "DNIs.txt";

		try {
			List<String> dnis= f.buscardnis( rutadatos+"/datos.txt");
			f.crearficheroresultado(dnis, ficheroSalida );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> buscardnis(String rutadatos) throws FileNotFoundException {
		int contador=0;
		String empiezapor="AN";
		List<String> dnis = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(rutadatos))) {
            while (in.hasNextLine()) {
                String linea = in.nextLine().trim();

                String[] partes = linea.split(",");
                    String identificador = partes[0].trim();
                    if (!identificador.startsWith(empiezapor)) {
                    	dnis.add(linea);
                        contador++;
                    }
                }
            }
        
        System.out.println("DNI:" + contador );

        return dnis;
}
    
	
	
	public void crearficheroresultado (List <String> dnis, String rutaFicheroSalida) throws IOException {
		//List<String> listaprovincias = contadortemperaturassuperiores(rutaficheroprovincias, provincia);
	        PrintWriter out = null;
	        try {
	            FileWriter ficheroSalida = new FileWriter(rutaFicheroSalida);
	            out = new PrintWriter(ficheroSalida);
	           for (String string : dnis) {
				out.println(string);
			};

	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	}
}
