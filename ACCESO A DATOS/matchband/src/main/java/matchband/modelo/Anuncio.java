package matchband.modelo;

import java.util.Objects;

public class Anuncio {
private int id;
private String titulo;
private String descripcion;
private TipoAnuncio tipoanuncio;
private double precio;
private boolean urgente;
private String fechacreacion;
public Anuncio(int id, String titulo, String descripcion, TipoAnuncio tipoanuncio, double precio, boolean urgente,
		String fechacreacion) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.tipoanuncio = tipoanuncio;
	this.precio = precio;
	this.urgente = urgente;
	this.fechacreacion = fechacreacion;
}
public Anuncio() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public TipoAnuncio getTipoanuncio() {
	return tipoanuncio;
}
public void setTipoanuncio(TipoAnuncio tipoanuncio) {
	this.tipoanuncio = tipoanuncio;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public boolean isUrgente() {
	return urgente;
}
public void setUrgente(boolean urgente) {
	this.urgente = urgente;
}
public String getFechacreacion() {
	return fechacreacion;
}
public void setFechacreacion(String fechacreacion) {
	this.fechacreacion = fechacreacion;
}
@Override
public String toString() {
	return "Anuncio [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", tipoanuncio=" + tipoanuncio
			+ ", precio=" + precio + ", urgente=" + urgente + ", fechacreacion=" + fechacreacion + "]";
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
	Anuncio other = (Anuncio) obj;
	return id == other.id;
}


}
