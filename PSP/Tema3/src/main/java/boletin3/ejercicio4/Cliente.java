 package boletin3.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 4444;
        String host = "localhost";
        PrintWriter salida= null;
        BufferedReader entrada=null;
        
        try {
            Socket socket = new Socket(host, puerto);
            salida = new PrintWriter(socket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje= entrada.readLine();
            System.out.println("Servidor dice " + mensaje);
            socket.getInputStream().read(); 
            
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
    }
}