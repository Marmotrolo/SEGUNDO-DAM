package flythread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AyudanteAtiendePeticionCliente extends Thread {
	private Socket socket;
	private Contador contador;
	private MapaFlyThread mapaasientos;

	public AyudanteAtiendePeticionCliente(Socket socket, Contador contador, MapaFlyThread mapaasientos) {
		super();
		this.contador = contador;
		this.socket = socket;
		this.mapaasientos= mapaasientos;
	}

	@Override
	public void run() {

		PrintWriter salida = null;
		BufferedReader entrada = null;
		String mensaje;
		contador.incrementar();

		try {

			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			salida = new PrintWriter(socket.getOutputStream(), true);

			mensaje = "Eres el cliente " + contador.getNumeroconexiones();
			salida.println(mensaje);
					String segundomensaje = "Dime tu vuelo (Numero de asiento y nombre) . Los asientos reservados son: "   +mapaasientos.getReservaasientos().keySet();
			salida.println(segundomensaje);
			String asientocliente = entrada.readLine();
			String resultadoreserva=mapaasientos.reservarasiento(asientocliente);
			
			salida.println(resultadoreserva);

		} catch (java.net.SocketException e) {
			// Capturamos el "Connection reset" para que no ensucie la consola
			System.out.println("El cliente" + contador.getNumeroconexiones() + " cerró la conexión .");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
