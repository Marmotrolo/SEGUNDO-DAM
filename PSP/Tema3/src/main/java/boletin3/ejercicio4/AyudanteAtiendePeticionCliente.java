package boletin3.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AyudanteAtiendePeticionCliente extends Thread {
	private Socket socket;
	private Contador contador;
	

public AyudanteAtiendePeticionCliente(Socket socket, Contador contador,Tablero tablero) {
		super();
		this.contador=contador;
		this.socket = socket;
	}


@Override
public void run() {
	
	
	PrintWriter salida=null;
	BufferedReader entrada=null;
	String mensaje;
    contador.incrementar();

	try {
		entrada= new BufferedReader( new InputStreamReader(socket.getInputStream()));

		salida = new PrintWriter(socket.getOutputStream(), true);

		mensaje= "Cliente conectado => " + contador.getNumeroconexiones();

		
	} 
	catch (java.net.SocketException e) {
        // Capturamos el "Connection reset" para que no ensucie la consola
        System.out.println("El cliente (Hilo " + this.getId() + ") cerró la conexión .");
        }
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}
