package hilos.servidorweb;

public class Peticion implements Runnable {
    private final ServidorWeb servidor;
    private String nombre;

    public Peticion(ServidorWeb servidor, String nombre) {
        super();
        this.servidor = servidor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            servidor.acquire();
            System.out.println(nombre + " está siendo atendida");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            servidor.release();
            System.out.println(nombre + " libera peticion");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void pagoConTarjeta() {
        System.out.println(nombre + " - Pago con tarjeta");
    }
}