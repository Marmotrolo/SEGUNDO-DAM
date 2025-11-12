package hilos;

public class GestionaMihilo {
public static void main(String[] args) {
    long inicio = System.currentTimeMillis(); // Tiempo inicial

	Mihilo hilo= new Mihilo("hilo1");
	
	hilo.start();
	
	Mihilo2 hilo2= new Mihilo2("hilo2");

	hilo2.start();


    try {
        // Espera a que terminen los hilos
        hilo.join();
        hilo2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    long fin = System.currentTimeMillis(); // Tiempo final
    System.out.println("Tiempo total del hilo padre: " + (fin - inicio) + " ms");
    System.out.println("Hilo padre ha terminado tras esperar a sus hijos.");
}
}
