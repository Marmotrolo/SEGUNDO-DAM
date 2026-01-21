package boletin3.ejercicio1;

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

	
		PrintWriter salida;
		try {
			salida = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader entrada = null;
			
			String mensajeparaservidor = "ola";
			salida.println(mensajeparaservidor);
				System.out.println("Conexion cerrada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	

	

}}

