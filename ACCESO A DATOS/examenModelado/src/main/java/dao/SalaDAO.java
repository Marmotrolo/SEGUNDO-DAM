package dao;

import modelo.Sala;
import utiles.AbstractDao;


public class SalaDAO extends AbstractDao<Sala> {

	public SalaDAO() {
		setClase(Sala.class);
	}
}
