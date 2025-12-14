package tallermecanico;

import java.util.concurrent.Semaphore;

public class Mecanico implements Runnable {
	private String nombre;
private int tiempomilisegundos; 
 private Semaphore semaforomecanico;
 private Semaphore semaforocoche;
 
 
 
 
 public Mecanico(String nombre, Semaphore semaforomecanico, Semaphore semaforocoche, int tiempomilisegundos) {
	super();
	this.nombre= nombre;
	this.tiempomilisegundos= tiempomilisegundos;
	this.semaforomecanico = semaforomecanico;
	this.semaforocoche = semaforocoche;
}




 @Override
 public void run() {
while(true)
	 	try {

	 		semaforocoche.acquire();
			System.out.println(nombre + " Reparando coche");
			Thread.sleep(tiempomilisegundos);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	 	finally {
	 		semaforomecanico.release();
	 	}
 }

 }
 
 
 
 

