package ejemploclientehilo;

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
		
				
			System.out.println("Conexion cerrada");

		
	

	

}}

