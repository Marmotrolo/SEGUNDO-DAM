package temperatura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnalizadorTemperaturas {

	
	public static void main(String[] args) {
		AnalizadorTemperaturas f = new AnalizadorTemperaturas();
		String rutaficheroumbrales= args[2];
		int umbral= Integer.parseInt(args[0]);
		String rutaficherocreacion= args[1];
		
		try {
			int numerodeumbralesmayor= f.contadortemperaturassuperiores( rutaficheroumbrales,  umbral);
			f.crearficheroresultado(rutaficheroumbrales,rutaficherocreacion , umbral);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int contadortemperaturassuperiores(String rutaficheroumbrales, int umbral) throws FileNotFoundException {
		
		int numerodevecessuperior=0;
		
		FileReader fichero = new FileReader(rutaficheroumbrales);
		Scanner in = new Scanner(fichero);
		while(in.hasNextLine()) {
			String linea= in.nextLine();
			
				if(Integer.parseInt(linea) > umbral) {
					numerodevecessuperior++;
				}
			 
			
			
			}
		return numerodevecessuperior;
	}
	
	public void crearficheroresultado (String rutaficheroumbrales, String rutaFicheroSalida, int umbral) throws IOException {
		int contador = contadortemperaturassuperiores(rutaficheroumbrales, umbral);
	        PrintWriter out = null;
	        try {
	            FileWriter ficheroSalida = new FileWriter(rutaFicheroSalida + umbral + ".txt");
	            out = new PrintWriter(ficheroSalida);

	            out.printf("El número de veces que se supera dicha temperatura es: %d", contador);

	        } finally {
	            if (out != null) {
	                out.close();
	            }
	        }
	}
	}
	
	
