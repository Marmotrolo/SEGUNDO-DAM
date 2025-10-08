package accesoDatosrepaso.libreria.modelos;

import java.util.Objects;

public class Libro {
private String ISBN;

private String autor;
private int añopublicacion;
private Genero generolibro;
private Editorial editorial;
private int numeroejemplar;



public Libro(String iSBN, String autor, int añopublicacion, Genero generolibro, Editorial editorial,
		int numeroejemplar) {
	super();
	ISBN = iSBN;
	this.autor = autor;
	this.añopublicacion = añopublicacion;
	this.generolibro = generolibro;
	this.editorial = editorial;
	this.numeroejemplar = numeroejemplar;
}



public String getISBN() {
	return ISBN;
}



public void setISBN(String iSBN) {
	ISBN = iSBN;
}



public String getAutor() {
	return autor;
}



public void setAutor(String autor) {
	this.autor = autor;
}



public int getAñopublicacion() {
	return añopublicacion;
}



public void setAñopublicacion(int añopublicacion) {
	this.añopublicacion = añopublicacion;
}



public Genero getGenerolibro() {
	return generolibro;
}



public void setGenerolibro(Genero generolibro) {
	this.generolibro = generolibro;
}



public Editorial getEditorial() {
	return editorial;
}



public void setEditorial(Editorial editorial) {
	this.editorial = editorial;
}



public int getNumeroejemplar() {
	return numeroejemplar;
}



public void setNumeroejemplar(int numeroejemplar) {
	this.numeroejemplar = numeroejemplar;
}



@Override
public int hashCode() {
	return Objects.hash(ISBN);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Libro other = (Libro) obj;
	return Objects.equals(ISBN, other.ISBN);
}



@Override
public String toString() {
	return "Libro [ISBN=" + ISBN + ", autor=" + autor + ", añopublicacion=" + añopublicacion + ", generolibro="
			+ generolibro + ", editorial=" + editorial + ", numeroejemplar=" + numeroejemplar + "]";
}

}
