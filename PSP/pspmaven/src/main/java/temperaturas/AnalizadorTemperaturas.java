package temperaturas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AnalizadorTemperaturas {

	public static void main(String[] args) throws FileNotFoundException {

		int	umbral= Integer.parseInt(args[1]) ;
		String archivo= args[0];

		System.out.println(contardiasmayoresalumbral(umbral, archivo));
		
	}

	
	
	
	
	
	
	public static int contardiasmayoresalumbral(int umbral, String archivo) throws FileNotFoundException {
		int numerodevecesEs=0;
		
		FileReader fichero = new FileReader(archivo);
		Scanner in = new Scanner(fichero);
		while(in.hasNextLine()) {
			String linea= in.nextLine();
			String[] palabras= linea.split(" ");
			
			for (String palabraitero : palabras) {
				int numeroumbral= Integer.parseInt(palabraitero);
				if(numeroumbral>umbral)
					numerodevecesEs++;
				}
			 
			
			
			}
		
		return numerodevecesEs;
	}
}
