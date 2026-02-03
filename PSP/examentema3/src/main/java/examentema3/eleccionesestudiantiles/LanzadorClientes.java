package examentema3.eleccionesestudiantiles;

public class LanzadorClientes {
	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 9; i++) {
			Thread clientehilo1 = new Thread(new ClienteHilo());
			clientehilo1.start();
			Thread.currentThread().sleep(2000);


		}

	}

}
