package tallermecanicoplus.modelo;

import java.util.concurrent.Semaphore;

public class Mecanico extends Thread{
private String nombre;
private Semaphore semaforoparking;
private Semaphore semaforocoches;
public Mecanico(String nombre, Semaphore semaforoparking, Semaphore semaforocoches) {
	super();
	this.nombre = nombre;
	this.semaforoparking = semaforoparking;
	this.semaforocoches = semaforocoches;
}
@Override
public void run() {
int i=0;
	while(true) {
	
		try {
			
			semaforocoches.acquire();
			System.out.println("El coche " + i +  " está siendo reparado");
			i++;
			Thread.sleep(3000);
			semaforoparking.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}




}
