package xml.modelo;

public class Producto {
private int id;
private boolean enventa;
private String nombre;
private double precio;
private int stock;
public Producto(int id, boolean enventa, String nombre, double precio, int stock) {
	super();
	this.id = id;
	this.enventa = enventa;
	this.nombre = nombre;
	this.precio = precio;
	this.stock = stock;
}
public Producto() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean isEnventa() {
	return enventa;
}
public void setEnventa(boolean enventa) {
	this.enventa = enventa;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
@Override
public String toString() {
	return "Producto [id=" + id + ", enventa=" + enventa + ", nombre=" + nombre + ", precio=" + precio + ", stock="
			+ stock + "]";
}



}
