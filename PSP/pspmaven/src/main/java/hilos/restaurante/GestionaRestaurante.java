package hilos.restaurante;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
    public static void main(String[] args) {
        List<Thread> hilos = new ArrayList<>();
        
        // Inicializamos semáforos. La profesora los inicia con valor y luego los vacía.
        // Esto asegura que empiecen en 0 (bloqueados).
        Semaphore semaforoMenu = new Semaphore(3);
        Semaphore semaforoClientes = new Semaphore(1);
        
        try {
            // TRUCO: Consumimos todos los permisos inmediatamente.
            // Estado final: semaforoClientes = 0, semaforoMenu = 0
            semaforoClientes.acquire(1);
            semaforoMenu.acquire(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creamos el Cocinero
        Cocinero cocinero = new Cocinero("Cocinero", semaforoClientes, semaforoMenu);
        Thread cocineroHilo = new Thread(cocinero);
        hilos.add(cocineroHilo);
        
        // Creamos 3 Comensales
        for (int i = 1; i <= 3; i++) {
            Comensales comensal = new Comensales("Comensal-" + i, semaforoClientes, semaforoMenu);
            Thread comensalHilo = new Thread(comensal);
            hilos.add(comensalHilo);
        }
        
        // Iniciamos todos
        for (Thread h : hilos) {
            h.start();
        }
        
        // Join para que el main no termine (aunque al ser bucles infinitos, no terminarán)
        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}