package boletin1.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSimple {
public static void main(String[] args) {
	int puerto=6000;
	int clientespermitidos= 3;
	ServerSocket servidor= null;
	Socket clienteconectado=null;
	int i=0;
	try {
		while(i<= clientespermitidos) {
		servidor= new ServerSocket(puerto);
		System.out.println("Servidor escuchando en el puerto "+ puerto);

		Socket cliente= servidor.accept();
		PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
		String mensajeparaservidor= "Cliente conectado" + i;
		salida.println(mensajeparaservidor);

		i++;
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
}
}
