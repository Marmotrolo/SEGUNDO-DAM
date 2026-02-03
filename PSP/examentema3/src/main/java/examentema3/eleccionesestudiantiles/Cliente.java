package examentema3.eleccionesestudiantiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

import examentema3.eleccionesestudiantiles.Candidato;

import java.net.Socket;
public class Cliente {

    public static void main(String[] args) {
    	Random randomnumero= new Random();

    	Cliente c= new Cliente();
        int puerto = 5555;
        String host = "localhost";
        PrintWriter salida=null;
		BufferedReader entrada= null;
        Scanner sc= new Scanner(System.in);
        try {
        	 
            Socket socket = new Socket(host, puerto);
            salida = new PrintWriter(socket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Conectado al servidor");
            
            char letradni= c.generaVoto().charAt(0);
           
            String dni= String.valueOf(randomnumero.nextInt(10000))+ letradni;
            String candidatogenerado= c.generaVoto();
            String voto= dni+":::"+candidatogenerado;
            //Envia el voto
            salida.println(voto);
            
           //Servidor envia el resultado del voto
            System.out.println(entrada.readLine());

            socket.getInputStream().read(); 
            
        } catch (Exception e) {
            System.err.println("Conexión finalizada.");
        }
    }
public String generaVoto() {
	Random random= new Random();
	Candidato[]valores=Candidato.values();
	int pos= random.nextInt(valores.length);
	return valores[pos].name();
}

}