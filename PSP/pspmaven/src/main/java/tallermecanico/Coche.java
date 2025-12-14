package tallermecanico;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable {
	private String nombre;
	 private Semaphore semaforomecanico;
	 private Semaphore semaforocoche;
	 public Coche(String nombre, Semaphore semaforomecanico, Semaphore semaforocoche) {
		super();
		this.nombre = nombre;
		this.semaforomecanico = semaforomecanico;
		this.semaforocoche = semaforocoche;
	 }
	 @Override
	 public void run() {

		 System.out.println(nombre +" ha llegado quiere reparar el coche");
		 try {
			semaforocoche.release();
			System.out.println(nombre + " su coche esta siendo reparado");

			semaforomecanico.acquire();

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 System.out.println(nombre +" Dice: Hasta luego ");
		 }
	 }
	 
	 
	 
	 
	 
}
