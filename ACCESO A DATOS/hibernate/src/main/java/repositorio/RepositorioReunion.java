package repositorio;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;
import modelo.Reunion;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RepositorioReunion extends AbstractDao <Reunion> {

	public  RepositorioReunion() {
		// TODO Auto-generated constructor stub	 {
		setClase(Reunion.class);
	}
	
	@Override
	public List<Reunion> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}
}

	

