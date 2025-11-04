package xml.modelo;

import java.util.List;

public class Pelicula {
private String titulopelicula;
private int año;
private String director;
private List<String> actores;




public Pelicula(String titulopelicula, int año, String director, List<String> actores) {
	super();
	this.titulopelicula = titulopelicula;
	this.año = año;
	this.director = director;
	this.actores = actores;
}


public Pelicula() {
	super();
	// TODO Auto-generated constructor stub
}


public String getTitulopelicula() {
	return titulopelicula;
	
}
public void setTitulopelicula(String titulopelicula) {
	this.titulopelicula = titulopelicula;
}
public int getAño() {
	return año;
}
public void setAño(int año) {
	this.año = año;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}

public List<String> getActores() {
	return actores;
}


public void setActores(List<String> actores) {
	this.actores = actores;
}


@Override
public String toString() {
	return "Pelicula [titulopelicula=" + titulopelicula + ", año=" + año + ", director=" + director + ", actores="
			+ actores + "]";
}


}

