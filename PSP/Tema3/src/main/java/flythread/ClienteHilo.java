package flythread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.Socket;

public class ClienteHilo extends Thread{

    
    @Override
    public void run() {
    	int puerto = 4444;
        String host = "localhost";
		PrintWriter salida=null;
		BufferedReader entrada= null;
		Scanner sc= new Scanner (System.in);

        try {
            Socket socket = new Socket(host, puerto);
            salida = new PrintWriter(socket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje= entrada.readLine();
            System.out.println("Servidor dice " + mensaje);
            String segundomensaje= entrada.readLine();
            System.out.println("Servidor dice " + segundomensaje);
            String asientoparaservidor= sc.nextLine();
            salida.println(asientoparaservidor);
            
            String resultadoreserva=entrada.readLine();
            
            System.out.println(resultadoreserva);
            socket.close();
            
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
        
    }
}