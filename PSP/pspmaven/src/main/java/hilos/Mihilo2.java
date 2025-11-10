package hilos;

public class Mihilo2 extends Thread {

	private String nombrehilo;
	
	
	
	public Mihilo2(String nombrehilo) {
		super();
		this.nombrehilo = nombrehilo;
	}



	public String getNombrehilo() {
		return nombrehilo;
	}



	public void setNombrehilo(String nombrehilo) {
		this.nombrehilo = nombrehilo;
	}



	@Override
	public void run() {
	System.out.println(this.nombrehilo +"estado:" +this.getState() );

	try {
		while (true) {
		System.out.println("PROCESOS");
		sleep(500);
		
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	System.out.println("Hilo terminado");
	}

}