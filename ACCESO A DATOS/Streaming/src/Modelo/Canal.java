package Modelo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class Canal {
private int idcanal;
private String titulo;
private LocalDate fechacreacion;



public Canal(int idcanal, String titulo, LocalDate fechacreacion) {
	super();
	this.idcanal = idcanal;
	this.titulo = titulo;
	this.fechacreacion = fechacreacion;
	
}
public int getIdcanal() {
	return idcanal;
}
public void setIdcanal(int idcanal) {
	this.idcanal = idcanal;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public LocalDate getFechacreacion() {
	return fechacreacion;
}
public void setFechacreacion(LocalDate fechacreacion) {
	this.fechacreacion = fechacreacion;
}
@Override
public int hashCode() {
	return Objects.hash(fechacreacion, idcanal, titulo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Canal other = (Canal) obj;
	return Objects.equals(fechacreacion, other.fechacreacion) && idcanal == other.idcanal
			&& Objects.equals(titulo, other.titulo);
}


}
