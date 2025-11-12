package modelo;

import java.util.Objects;

public class Equipo {
private String nombre;
private String id;
private int numjugadores;
private String emailcontacto;
public Equipo(String nombre, String id, int numjugadores, String emailcontacto) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.numjugadores = numjugadores;
	this.emailcontacto = emailcontacto;
}
public Equipo() {
	super();
	// TODO Auto-generated constructor stub
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getNumjugadores() {
	return numjugadores;
}
public void setNumjugadores(int numjugadores) {
	this.numjugadores = numjugadores;
}
public String getEmailcontacto() {
	return emailcontacto;
}
public void setEmailcontacto(String emailcontacto) {
	this.emailcontacto = emailcontacto;
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
	Equipo other = (Equipo) obj;
	return Objects.equals(id, other.id);
}
@Override
public String toString() {
	return "Equipo [nombre=" + nombre + ", id=" + id + ", numjugadores=" + numjugadores + ", emailcontacto="
			+ emailcontacto + "]";
}


}
