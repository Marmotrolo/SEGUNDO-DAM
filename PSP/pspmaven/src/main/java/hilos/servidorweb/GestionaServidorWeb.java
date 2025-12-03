package hilos.servidorweb;

import java.util.ArrayList;
import java.util.List;

public class GestionaServidorWeb {
	public static void main(String[] args) {

		ServidorWeb servidor = new ServidorWeb(12);
		int numHilos = 20;
		
		List<Thread> hilos = new ArrayList<>();
		
		for(int i = 0; i < numHilos; i++)
		{
			hilos.add(new Thread(new Peticion(servidor, "Peticion "+(i+1))));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}}

