package accesoDatosrepaso.libreria.services;

import accesoDatosrepaso.libreria.modelos.Genero;
import accesoDatosrepaso.libreria.modelos.Libro;
import accesoDatosrepaso.libreria.repositorios.LibroRepository;

public class Libroservice {

	
	LibroRepository librorepositorio = new LibroRepository ();

	public Libroservice(LibroRepository librorepositorio) {
		super();
		this.librorepositorio = librorepositorio;
	}

	public LibroRepository getLibrorepositorio() {
		return librorepositorio;
	}

	public void setLibrorepositorio(LibroRepository librorepositorio) {
		this.librorepositorio = librorepositorio;
	}
	
	public Libro buscarlibroporgenero (Genero genero) {
		 for( Libro libros: librorepositorio.getLibros()) {
			 
			 
		 }
		 return null;
		 
		 }
}
