 package boletin3.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 4444;
        String host = "localhost";
        PrintWriter salida= null;
        BufferedReader entrada=null;
        Scanner sc= new Scanner(System.in);
        
        try {
            Socket socket = new Socket(host, puerto);
            salida = new PrintWriter(socket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje= entrada.readLine();
            System.out.println("Servidor dice " + mensaje);
            String segundomensaje=entrada.readLine();
            System.out.println("Servidor dice " + segundomensaje);
            String mensajeparaservidor= sc.nextLine();
            salida.println(mensajeparaservidor);
            System.out.println("Servidor: Resultado apuesta" + entrada.readLine());
            socket.getInputStream().read(); 
            
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
    }
}