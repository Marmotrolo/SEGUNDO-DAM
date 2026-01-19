package boletin3.ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AyudanteAtiendePeticionCliente extends Thread {
	private Socket socket;
	

public AyudanteAtiendePeticionCliente(Socket socket) {
		super();
		this.socket = socket;
	}


@Override
public void run() {
	PrintWriter salida = null;
	BufferedReader entrada = null;
	
	try {
		entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		salida = new PrintWriter(socket.getOutputStream(), true);
		salida.println("Bienvenido. Escribe algo (o 'fin' para salir):");
		String mensaje;
		while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
				System.out.println("Cliente dice: " + mensaje);
				salida.println("Servidor responde: " + mensaje.toUpperCase());
		}
		if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
			salida.println("Cerrando sesión. ¡Hasta pronto!"); 			
	}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
}