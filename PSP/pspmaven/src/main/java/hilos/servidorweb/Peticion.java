package hilos.servidorweb;

public class Peticion implements Runnable {
	   private final ServidorWeb servidor;
	   private String nombre;
	   
	   public Peticion(ServidorWeb servidor, String nombre) {
	       super();
	       this.servidor = servidor;
	       this.nombre= nombre;
	   }

	   @Override
	   public void run() {
		   servidor.atiende();
		   
	   }

	   public String getNombre() {
		   return nombre;
	   }

	   public void setNombre(String nombre) {
		   this.nombre = nombre;
	   }
	   
	}
