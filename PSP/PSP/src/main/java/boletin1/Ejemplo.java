package boletin1;

import java.io.IOException;

public class Ejemplo {
public static void main(String[] args) {
	Runtime kernel = Runtime.getRuntime();
	
	
	System.out.println(kernel.totalMemory());
	System.out.println(kernel.maxMemory());
	System.out.println(kernel.freeMemory());
	String [] argumentos = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "https://educacionadistancia.juntadeandalucia.es/centros/sevilla/my/" };
	
	try {
		kernel.exec(argumentos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
