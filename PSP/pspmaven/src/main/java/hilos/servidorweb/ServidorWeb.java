package hilos.servidorweb;

import java.util.concurrent.Semaphore;

public class ServidorWeb {
    private Semaphore semaforo;

    public ServidorWeb(int numeroConexiones) {
        semaforo = new Semaphore(numeroConexiones);
    }

    public void acquire() throws InterruptedException {
        semaforo.acquire();
    }

    public void release() {
        semaforo.release();
    }
}
