package hilos;

public class GestionaMihilo {
public static void main(String[] args) {
	Mihilo hilo= new Mihilo("hilo1");
	
	hilo.start();
	
	Mihilo2 hilo2= new Mihilo2("hilo2");

	hilo2.start();

	
}
}
