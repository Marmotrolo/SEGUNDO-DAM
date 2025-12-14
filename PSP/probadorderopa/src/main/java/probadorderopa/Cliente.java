package probadorderopa;

public class Cliente implements Runnable {

	private Probadordetienda probador;
	private String nombre;
	
	
	
	
	public Cliente(Probadordetienda probador, String nombre) {
		super();
		this.probador = probador;
		this.nombre = nombre;
	}




	@Override
	public void run() {
		
	}
	
	

}
