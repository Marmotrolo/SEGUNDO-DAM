package hilos.gasolinera;

public class Coche extends Thread {
	   private final ConexionBBDD semaforo;

	   public Coche(ConexionBBDD semaforo, String nombre) {
	       super(nombre);
	       this.semaforo = semaforo;
	   }

	   @Override
	   public void run() {
	   	semaforo.conexion();
	   }
	}
