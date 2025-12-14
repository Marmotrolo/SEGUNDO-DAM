package hilos.restaurante;
import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {
    private String nombreHilo;
    private Semaphore semaforoClientes;
    private Semaphore semaforoMenu;

    public Cocinero(String nombreHilo, Semaphore semaforoClientes, Semaphore semaforoMenu) {
        this.nombreHilo = nombreHilo;
        this.semaforoClientes = semaforoClientes;
        this.semaforoMenu = semaforoMenu;
    }

    @Override
    public void run() {
        while (true) { // Bucle infinito: el cocinero siempre está listo
            try {
                // PASO 1: ESPERAR AVISO DEL CLIENTE
                // Se queda bloqueado aquí hasta que un cliente haga semaforoClientes.release()
                semaforoClientes.acquire();
                
                System.out.println( nombreHilo + " empieza a cocinar...");
                Thread.sleep(4000); // Tiempo de cocinado
                System.out.println( nombreHilo + " ha terminado el plato.");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // PASO 2: AVISAR QUE HAY COMIDA
                // Libera un permiso en el menú para desbloquear a un comensal
                semaforoMenu.release();
            }
        }
    }
}