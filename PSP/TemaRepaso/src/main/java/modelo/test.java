package modelo;

import java.time.LocalDate;

import excepcion.CraftersException;

public class test {

	public static void main(String[] args) {
		
		Evento fornite = new Evento ("Fornite cubo", LocalDate.of(2025,2,10) , 4, Estado.CANCELADO);
		
		System.out.println(fornite);
	}

}
