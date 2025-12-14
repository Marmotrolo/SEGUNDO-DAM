package concierto;

import java.util.Random;

public class Terminal extends Thread {
	private String nombre;
	private Concierto concierto;
	private int entradasavender;

	public Terminal(String nombre, Concierto concierto) {
		super();
		this.nombre=nombre;
		this.concierto= concierto;
		this.entradasavender = ((int) (Math.random()*3+1));
	}

	@Override
	public void run() {

		concierto.vendeentradas(entradasavender);
		
	}
	

	
	
}
