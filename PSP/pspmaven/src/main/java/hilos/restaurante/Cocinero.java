package hilos.restaurante;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {
	private Semaphore comida;
	
	
	public Cocinero(Semaphore comida) {
		comida = new Semaphore(3);
	}
	
	
	private void dadecomer() {
		try {
			comida.acquire(3);
			System.out.println(Thread.currentThread().getName() + " esta comiendo");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			comida.release(3);
			System.out.println(Thread.currentThread().getName() + " ya ha comido");
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
