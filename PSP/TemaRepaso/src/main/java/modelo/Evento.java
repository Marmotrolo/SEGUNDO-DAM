package modelo;

import java.time.LocalDate;
import java.util.Objects;

import excepcion.CraftersException;

public class Evento {
 private static int contador;
 private int id;
 private String nombre;
 private final LocalDate fecha;
 private int numentradasvendidas;
 private int capacidadmax;
 private Estado estadoevento;

 public Evento( String nombre, LocalDate fecha, int capacidadmax, Estado estadoevento) {
	super();
	this.id = contador;
	contador++;
	this.nombre = nombre;
	this.fecha = fecha;
    try {
		this.setCapacidadmax(capacidadmax);
	} catch (CraftersException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	this.capacidadmax = capacidadmax;
	this.estadoevento = estadoevento;
}
 public static int getContador() {
	return contador;
 }
 public static void setContador(int contador) {
	Evento.contador = contador;
 }
 public int getId() {
	return id;
 }
 public void setId(int id) {
	this.id = id;
 }
 public String getNombre() {
	return nombre;
 }
 public void setNombre(String nombre) {
	this.nombre = nombre;
 }
 public int getNumentradasvendidas() {
	return numentradasvendidas;
 }
 public void setNumentradasvendidas(int numentradasvendidas) throws CraftersException {
	 if(numentradasvendidas <0) {
		 throw new CraftersException ("A tomar por culo excepcion pa ti");
	 }
	 else {
	this.numentradasvendidas = numentradasvendidas;}
 }
 public int getCapacidadmax() {
	return capacidadmax;
 }
 public void setCapacidadmax(int capacidadmax) throws CraftersException {
	 if(capacidadmax <0) {
		 throw new CraftersException ("A tomar por culo excepcion pa ti");
	 }
	 else {
	this.capacidadmax = capacidadmax;
	}
 }
 public LocalDate getFecha() {
	return fecha;
 }
 @Override
 public int hashCode() {
	return Objects.hash(id);
 }
 @Override
 public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Evento other = (Evento) obj;
	return id == other.id;
 }
 @Override
 public String toString() {
	return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", numentradasvendidas="
			+ numentradasvendidas + ", capacidadmax=" + capacidadmax + ", estadoevento=" + estadoevento + "]";
 }
 

 
}
