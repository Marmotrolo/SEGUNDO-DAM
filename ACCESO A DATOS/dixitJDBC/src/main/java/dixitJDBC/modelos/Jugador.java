package dixitJDBC.modelos;

public class Jugador {
private int id;
private String nombre;
private String email;
private int puntostotales;
public Jugador(String nombre, String email, int puntostotales) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.puntostotales = puntostotales;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPuntostotales() {
	return puntostotales;
}
public void setPuntostotales(int puntostotales) {
	this.puntostotales = puntostotales;
}
@Override
public String toString() {
	return "Jugador [id=" + id + ", nombre=" + nombre + ", email=" + email + ", puntostotales=" + puntostotales + "]";
}


}
