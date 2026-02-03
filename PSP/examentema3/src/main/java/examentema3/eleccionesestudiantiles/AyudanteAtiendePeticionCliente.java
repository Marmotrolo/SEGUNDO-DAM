			package examentema3.eleccionesestudiantiles;
			
			import java.io.BufferedReader;
			import java.io.IOException;
			import java.io.InputStreamReader;
			import java.io.PrintWriter;
			import java.net.Socket;
import java.time.LocalTime;
			
			public class AyudanteAtiendePeticionCliente extends Thread {
				private Socket socket;
				private Votos votos;
				
			
			public AyudanteAtiendePeticionCliente(Socket socket, Votos votos) {
					super();
					this.socket = socket;
					this.votos=votos;
				}
			
			
			@Override
			public void run() {
			
				
					PrintWriter salida=null;
					BufferedReader entrada=null;
					String mensaje;
					
					try {
						entrada= new BufferedReader( new InputStreamReader(socket.getInputStream()));

						salida = new PrintWriter(socket.getOutputStream(), true);
						//Lee el voto
						String votodelcliente= entrada.readLine();
						if(!votodelcliente.equals(null) || !votodelcliente.equals("")) {
						 String resultadovotos= votos.votar(votodelcliente);
						 //Envia el resultado del voto
						salida.println(resultadovotos);
						}
						
						
					} 
					catch (java.net.SocketException e) {
				        System.out.println("El cliente (Hilo " + this.getId() + ") cerró la conexión .");
				        }
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
			}
			
