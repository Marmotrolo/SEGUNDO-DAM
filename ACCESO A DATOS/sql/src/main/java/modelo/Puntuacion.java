package modelo;

public class Puntuacion {
private double puntuacion;
private String type;
public Puntuacion(double puntuacion, String type) {
	super();
	this.puntuacion = puntuacion;
	this.type = type;
}



public double getPuntuacion() {
	return puntuacion;
}



public void setPuntuacion(double puntuacion) {
	this.puntuacion = puntuacion;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



@Override
public String toString() {
	return "Puntuacion [puntuacion=" + puntuacion + ", type=" + type + "]";
}


}
