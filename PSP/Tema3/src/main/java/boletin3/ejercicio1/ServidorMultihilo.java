	package boletin3.ejercicio1;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.ServerSocket;
	import java.net.Socket;
import java.time.LocalDateTime;

	
	public class ServidorMultihilo {
	
	public static void main(String[] args) {
		
		   int puerto = 4444;
		   ServerSocket servidor = null;
		   try {
	            servidor = new ServerSocket(puerto);
	            System.out.println("Servidor ECO iniciado en puerto " + puerto);

	            while (true) {
	                Socket socketCliente = servidor.accept();
	                System.out.println("Nueva conexión: " + socketCliente.getPort());
	                
	                // Lanzamos el hilo y nos olvidamos, él se encarga de cerrar su socket
	                AyudanteAtiendePeticionCliente hilo = new AyudanteAtiendePeticionCliente(socketCliente);
	                hilo.start();
	            }
	        } catch (IOException e) {
	            System.err.println("Error en el servidor: " + e.getMessage());
	        } 
	        
	    }
	}
