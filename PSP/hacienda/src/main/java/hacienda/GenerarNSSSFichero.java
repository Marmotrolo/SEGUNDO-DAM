package hacienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerarNSSSFichero {
	private static final String rutadatos= "src/main/resources/";

	public static void main(String[] args) {
		GenerarNSSSFichero f = new GenerarNSSSFichero();

	//	String rutaficheroprovincias= args[2];
	//	String rutaficherocreacion= args[1];
        String ficheroSalida = rutadatos +  "NSSs.txt";

		try {
			List<String> nsses= f.buscarnss( rutadatos+"/datos.txt");
			f.crearficheroresultado(nsses, ficheroSalida );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> buscarnss(String rutadatos) throws FileNotFoundException {
		int contador=0;
		String empiezapor="AN";
		List<String> nsses = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(rutadatos))) {
            while (in.hasNextLine()) {
                String linea = in.nextLine().trim();

                String[] partes = linea.split(",");
                    String identificador = partes[0].trim();
                    if (identificador.startsWith(empiezapor)) {
                    	nsses.add(linea);
                        contador++;
                    }
                }
            }
        
        System.out.println("NSS:" + contador );

        return nsses;
}
    
	
	
	public void crearficheroresultado (List <String> nsses, String rutaFicheroSalida) throws IOException {
		//List<String> listaprovincias = contadortemperaturassuperiores(rutaficheroprovincias, provincia);
	        PrintWriter out = null;
	        try {
	            FileWriter ficheroSalida = new FileWriter(rutaFicheroSalida);
	            out = new PrintWriter(ficheroSalida);
	           for (String string : nsses) {
				out.println(string);
			};

	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	}
}
