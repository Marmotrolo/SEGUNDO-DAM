package tallermecanico;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaTaller {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis(); // Tiempo inicial

        List<Thread> hilos = new ArrayList<>();
        
        // Inicializamos semáforos. La profesora los inicia con valor y luego los vacía.
        // Esto asegura que empiecen en 0 (bloqueados).
        Semaphore semaforomecanico = new Semaphore(2);
        Semaphore semaforocoches = new Semaphore(2);
        
        try {
            // TRUCO: Consumimos todos los permisos inmediatamente.
            // Estado final: semaforoClientes = 0, semaforoMenu = 0
        	semaforocoches.acquire(2);
            semaforomecanico.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creamos el Cocinero
        Mecanico mecanico = new Mecanico("Mecanico 1" ,  semaforocoches, semaforomecanico, 5000);
        Thread mecanicohilo = new Thread(mecanico);
        mecanicohilo.start();
        Mecanico mecanico2 = new Mecanico("Mecanico 2" , semaforocoches, semaforomecanico, 8000);
        Thread mecanicohilo2 = new Thread(mecanico2);
        mecanicohilo2.start();
        
        // Creamos 3 Comensales
        for (int i = 1; i <= 5; i++) {
            Coche coche = new Coche("Coche-" + i, semaforocoches, semaforomecanico);
            Thread cocheHilo = new Thread(coche);
            hilos.add(cocheHilo);
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
        long fin = System.currentTimeMillis(); // Tiempo final
        System.out.println("Tiempo total del hilo padre: " + (fin - inicio) + " ms");

       
    }
}