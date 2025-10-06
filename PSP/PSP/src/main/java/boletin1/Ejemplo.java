package boletin1;

import java.io.IOException;

public class Ejemplo {
public static void main(String[] args) {


	String[] comando = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\\", 
	"https://www.marca.com/"};
ProcessBuilder pb = new ProcessBuilder (comando);
	try {
		Process p = ;
	} catch (IOException e) {			
		System.out.println(e);
	}
}

	
		Runtime rt = Runtime.getRuntime();
		String[] informacionProceso = {"NotePad.exe"};
		Process proceso;
		try {
			proceso = rt.exec(informacionProceso);
			int codigoRetorno = proceso.waitFor(); //Espero a que termine
System.out.println(codigoRetorno);
} catch (IOException e) {
			e.getMessage();
		} catch (InterruptedException e) {
		e.getMessage();
		}
		
	}

}
		
		
	
