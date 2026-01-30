package flythread;

public class LanzadorClientes {
	public static void main(String[] args) {

		for (int i = 0; i < 1; i++) {
			Thread clientehilo1 = new Thread(new ClienteHilo());
			clientehilo1.start();

		}

	}

}
