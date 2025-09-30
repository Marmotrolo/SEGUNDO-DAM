package accesoDatosrepaso.libreria.repositorios;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import accesoDatosrepaso.libreria.modelos.Libro;

public class LibroRepository {

 private Set<Libro> libros; 
	
	
	public void addlibro (Libro libronuevo) {
	 libros.add(libronuevo);
	 }
	
	

	public Libro leelibro(String ISBN) {
		Libro libro=null;
		boolean encontrado=false;
		Iterator<Libro> libroitero= libros.iterator();
		
		while (libroitero.hasNext()) {
			Libro libroleido =libroitero.next();
			
			if (libro.getISBN().equals(libroleido) & !encontrado) {
				libro = libroleido;
				encontrado= true;
			}
			
			
		}
		return libro;
	}



	public Set<Libro> getLibros() {
		return libros;
	}



	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	
	
}
	        
	   
	    


