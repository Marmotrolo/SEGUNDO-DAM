package boletin3.ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 5555;
        String host = "localhost";
        
        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor. El servidor me cerrará en 5 segundos...");
            
            // Leemos para mantener la conexión viva hasta que el servidor cierre
            socket.getInputStream().read(); 
            
            socket.close();
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
    }
}