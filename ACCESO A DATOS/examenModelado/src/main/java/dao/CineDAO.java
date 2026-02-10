package dao;

import modelo.Cine;
import utiles.AbstractDao;


public class CineDAO extends AbstractDao<Cine> {

	public CineDAO() {
		setClase(Cine.class);
	}
}
