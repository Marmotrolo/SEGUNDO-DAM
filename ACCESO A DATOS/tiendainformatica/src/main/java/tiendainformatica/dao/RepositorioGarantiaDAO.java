package tiendainformatica.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import tiendainformatica.model.Garantia;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RepositorioGarantiaDAO extends AbstractDao<Garantia> {

	public RepositorioGarantiaDAO() {
		setClase(Garantia.class);
	}
	
	
}
