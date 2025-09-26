package accesoDatosrepaso.libreria.modelos;

import java.util.Objects;

public class Editorial {
private String nombre;
private String direccion;
private String cif;
private String web;
private String emailcontacto;
public Editorial(String nombre, String direccion, String cif, String web, String emailcontacto) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.cif = cif;
	this.web = web;
	this.emailcontacto = emailcontacto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getCif() {
	return cif;
}
public void setCif(String cif) {
	this.cif = cif;
}
public String getWeb() {
	return web;
}
public void setWeb(String web) {
	this.web = web;
}
public String getEmailcontacto() {
	return emailcontacto;
}
public void setEmailcontacto(String emailcontacto) {
	this.emailcontacto = emailcontacto;
}
@Override
public int hashCode() {
	return Objects.hash(cif);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Editorial other = (Editorial) obj;
	return Objects.equals(cif, other.cif);
}
@Override
public String toString() {
	return "Editorial [nombre=" + nombre + ", direccion=" + direccion + ", cif=" + cif + ", web=" + web
			+ ", emailcontacto=" + emailcontacto + "]";
}


}
