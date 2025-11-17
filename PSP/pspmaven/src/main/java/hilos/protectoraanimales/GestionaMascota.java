package hilos.protectoraanimales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionaMascota {


public static void main(String[] args) {
	Mascota lulu= new Mascota("lulu", 0);

	List<Thread> listacuidadores= new ArrayList<Thread>();
	/*Thread cuidador1= new Thread(lulu, "Cuidador1");
	Thread cuidador2= new Thread(lulu, "Cuidador21");
	Thread cuidador3= new Thread(lulu, "Cuidador3");
	Thread cuidador4= new Thread(lulu, "Cuidador4");
	Thread cuidador5= new Thread(lulu, "Cuidador5");
	
	
	cuidador1.start();
	cuidador2.start();
	cuidador3.start();
	cuidador4.start();
	cuidador5.start();
	
	try {
		cuidador1.join();
		cuidador2.join();
		cuidador3.join();
		cuidador4.join();
		cuidador5.join();

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	for (int i = 1; i <=10; i++) {
		Thread cuidador = new Thread (lulu, "cuidador" +i);	
		cuidador.setPriority(11-i);
		cuidador.getPriority();

		listacuidadores.add(cuidador);
		cuidador.start();

	}
	for (Thread thread : listacuidadores) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	System.out.println(lulu.getVecesCome());

}

}
