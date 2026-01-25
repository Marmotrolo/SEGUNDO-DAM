package ejemploclientehilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import java.net.Socket;

public class ClienteHilo extends Thread{

    
    @Override
    public void run() {
    	int puerto = 5555;
        String host = "localhost";
        
        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor" + socket.getInetAddress());
            
            // Leemos para mantener la conexión viva hasta que el servidor cierre
            socket.getInputStream().read(); 
            
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
    }
}