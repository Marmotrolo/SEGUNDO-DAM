package tallermecanicoplus.modelo;

import java.util.concurrent.Semaphore;

public class GestionaTaller {
public static void main(String[] args) {
	Semaphore semaforoparking= new Semaphore(5);
	Semaphore semaforocoches =new Semaphore(0);
	int coches= 20;
	
	Grua grua1= new Grua("Grua1", coches, semaforoparking, semaforocoches);
	
	Mecanico mecanico1= new Mecanico("Mecanico1", semaforoparking, semaforocoches);
	
	
	grua1.start();
	mecanico1.start();
	try {
		grua1.join();
		mecanico1.join();

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
