package tiendainformatica.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import tiendainformatica.model.Categoria;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RepositorioCategoriaDAO extends AbstractDao<Categoria> {

	public RepositorioCategoriaDAO() {
		setClase(Categoria.class);
	}

}
