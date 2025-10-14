package concertcrafters.modelo;

import java.time.LocalDate;

public abstract class Evento {
private int id;
private static int contador;
private String nombre;
private LocalDate fecha;
private int numeroentradasvendidas;
private int capacidadmaxima;
public Evento( String nombre, LocalDate fecha, int numeroentradasvendidas, int capacidadmaxima) {
	super();
	this.id = contador;
	contador= contador++;
	this.nombre = nombre;
	this.fecha = fecha;
	this.numeroentradasvendidas = numeroentradasvendidas;
	this.capacidadmaxima = capacidadmaxima;
	
}
protected abstract int calcularcosteBase();


}
