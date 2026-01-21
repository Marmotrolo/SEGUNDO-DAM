package boletin3.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import boletin3.ejercicio0.AyudanteAtiendePeticionCliente;

public class ServidorMultihilo {

public static void main(String[] args) {
	
	   int puerto = 5555;
       try (ServerSocket servidor = new ServerSocket(puerto)) {
           System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
           while (true) {
               // 1. Espera a un cliente
               Socket socketCliente = servidor.accept();
               System.out.println("Nuevo cliente conectado: " + socketCliente.getPort());
               // 2. Lanza un hilo nuevo para este cliente específico
               // Esto permite que el bucle vuelva al accept() inmediatamente
               new AyudanteAtiendePeticionCliente(socketCliente).start();
       		BufferedReader entrada= new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
       		System.out.println("echo" + entrada.readLine());
           }
       } catch (IOException e) {
           System.err.println("Error en el servidor: " + e.getMessage());
       }
   }

}
