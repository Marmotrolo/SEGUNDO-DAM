package hilos;

public class HiloRunnable implements Runnable {
	private String nombreHilo;
	
	public HiloRunnable(String nombre) {
		super();
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());		
	}
}


