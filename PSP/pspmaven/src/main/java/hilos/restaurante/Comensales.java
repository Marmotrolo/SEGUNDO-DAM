package hilos.restaurante;
import java.util.concurrent.Semaphore;

public class Comensales implements Runnable {
    private String nombreHilo;
    private Semaphore semaforoClientes;
    private Semaphore semaforoMenu;

    public Comensales(String nombreHilo, Semaphore semaforoClientes, Semaphore semaforoMenu) {
        this.nombreHilo = nombreHilo;
        this.semaforoClientes = semaforoClientes;
        this.semaforoMenu = semaforoMenu;
    }

    @Override
    public void run() {
             try {
                System.out.println( nombreHilo + " tiene hambre y se sienta.");
                
                // PASO 1: AVISAR AL COCINERO
                // "Hola, estoy aquí". Despierta al cocinero bloqueado.
                semaforoClientes.release();
                
                // PASO 2: ESPERAR LA COMIDA
                // Se queda bloqueado aquí hasta que el cocinero haga semaforoMenu.release()
                semaforoMenu.acquire();
                
                System.out.println( nombreHilo + " está comiendo.");
                Thread.sleep(4000); // Tiempo comiendo
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(nombreHilo + " terminó y se va.");
                // NOTA: No hacemos release() de nada porque hemos consumido la comida.
            }
        }
    }
