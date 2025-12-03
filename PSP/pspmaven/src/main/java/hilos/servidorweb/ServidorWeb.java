package hilos.servidorweb;

import java.util.concurrent.Semaphore;

public class ServidorWeb {
	private Semaphore semaforo;

	public ServidorWeb(int numeroConexiones) {
		semaforo = new Semaphore(numeroConexiones);
	}
	public void atiende() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " está siendo atendida");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + " libera peticion");
		}}
	public void pagocontarjeta() {
		System.out.println( Thread.currentThread().getName()+ "Pago con tarjeta");
		
	}
	
}