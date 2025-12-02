package hilos.gasolinera;

import java.util.ArrayList;
import java.util.List;

public class GestionaGasolinera {
	public static void main(String[] args) {

		ConexionBBDD baseDatos = new ConexionBBDD(3);
		int numHilos = 8;
		
		List<Thread> hilos = new ArrayList<>();
		
		for(int i = 0; i < numHilos; i++)
		{
			hilos.add(new Coche(baseDatos, "Coche "+(i+1)));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}}

