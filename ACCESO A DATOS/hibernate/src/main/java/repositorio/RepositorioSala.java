package repositorio;

import modelo.Reunion;
import modelo.Sala;
import utiles.AbstractDao;

public class RepositorioSala extends AbstractDao<Sala>{

	public RepositorioSala() {
		setClase(Sala.class);
	}

}
