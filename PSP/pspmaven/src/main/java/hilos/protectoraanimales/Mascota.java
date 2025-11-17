package hilos.protectoraanimales;

public class Mascota implements Runnable {
private String nombre;
private int vecesCome;


	
	public Mascota(String nombre, int vecesCome) {
	super();
	this.nombre = nombre;
	this.vecesCome = vecesCome;
}



	public String getNombre() {
	return nombre;
}



public void setNombre(String nombre) {
	this.nombre = nombre;
}



public int getVecesCome() {
	return vecesCome;
}



public void setVecesCome(int vecesCome) {
	this.vecesCome = vecesCome;
}

public void come() throws InterruptedException {
	System.out.println(nombre + "ha empezado a comer" + Thread.currentThread().getName());
	vecesCome ++;
	Thread.sleep(100*vecesCome);
	System.out.println(nombre + "ha terminado de comer");
}

	@Override
	public void run() {
		try {
			come();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.currentThread().setName(nombre);
	
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());	
		
	}

}
