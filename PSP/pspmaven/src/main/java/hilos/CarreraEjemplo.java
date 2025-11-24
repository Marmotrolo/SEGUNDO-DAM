package hilos;

public class CarreraEjemplo {
	public static void main(String[] args) throws InterruptedException {
		   long inicio = System.currentTimeMillis(); // Tiempo inicial

	       Contador contador = new Contador();
	       Thread t1 = new Thread(new TareaIncremento(contador));
	       Thread t2 = new Thread(new TareaIncremento(contador));
	       Thread t3 = new Thread(new TareaIncremento(contador));
	       Thread t4 = new Thread(new TareaIncremento(contador));
	       t1.start();
	       t2.start();
	       t3.start();
	       t4.start();
	       t1.join();
	       t2.join();
	       t3.join();
	       t4.join();
	       System.out.println("Valor final: " + contador.getValor());
			long fin = System.currentTimeMillis(); // Tiempo final

		   System.out.println("Tiempo total del hilo padre: " + (fin - inicio) + " ms");

	   }

}
