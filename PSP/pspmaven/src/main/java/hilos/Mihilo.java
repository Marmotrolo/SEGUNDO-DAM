package hilos;

public class Mihilo extends Thread {

	private String nombrehilo;
	
	
	
	public Mihilo(String nombrehilo) {
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
		System.out.println("SERVICIOS");
		sleep(500);
		
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	System.out.println("Hilo terminado");
	}

}