package tallermecanicoplus.modelo;

import java.util.concurrent.Semaphore;

public class Grua extends Thread {
private String nombre;
private int coches;
private Semaphore semaforoparking;
private Semaphore semaforocoches;


public Grua(String nombre, int coches, Semaphore semaforoparking, Semaphore semaforocoches) {
	super();
	this.nombre = nombre;
	this.coches=coches;
	this.semaforoparking = semaforoparking;
	this.semaforocoches = semaforocoches;
}


@Override
public void run() {
	int i =0;
	while(i!=coches+ 1) {
		try {
			semaforoparking.acquire();
			Thread.sleep(1000);
			System.out.println("Coche "+ i + " está en el parking");
			i++;
			semaforocoches.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



}
