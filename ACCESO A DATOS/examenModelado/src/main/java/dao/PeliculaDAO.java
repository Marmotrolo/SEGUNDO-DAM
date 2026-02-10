package dao;

import modelo.Pelicula;
import utiles.AbstractDao;


public class PeliculaDAO extends AbstractDao<Pelicula> {

	public PeliculaDAO() {
		setClase(Pelicula.class);
	}
}
