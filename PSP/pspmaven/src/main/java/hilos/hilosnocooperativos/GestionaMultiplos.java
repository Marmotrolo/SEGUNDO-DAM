package hilos.hilosnocooperativos;

public class GestionaMultiplos {
	public static void main(String[] args) {
		long t_comienzo = System.currentTimeMillis();
// Creo 3 instancias de Multiplo asociados, cada uno a un hilo. 3 objetos y 3 hilos
		MultiplosCooperativos multDe2 = new MultiplosCooperativos(2);
		MultiplosCooperativos multDe3 = new MultiplosCooperativos(3);
		MultiplosCooperativos multDe7 = new MultiplosCooperativos(7);


		Thread hilo1 = new Thread(multDe2);
		Thread hilo2 = new Thread(multDe3);
		Thread hilo3 = new Thread(multDe7);
		try {
			hilo1.start();
			hilo2.start();
			hilo3.start();
			hilo1.join();
			hilo2.join();
			hilo3.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		long t_fin = System.currentTimeMillis();
		long tiempototal = t_fin - t_comienzo;
		System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");
	}

}
