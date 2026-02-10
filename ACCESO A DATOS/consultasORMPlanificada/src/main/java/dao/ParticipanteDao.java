package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Participante;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ParticipanteDao extends AbstractDao<Participante> {

	public ParticipanteDao() {
		setClase(Participante.class);
	}
	
	public List<Participante> obtenerparticipantenombreascdentemente() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Participante p ORDER BY p.apellidos ASC";
			Query<Participante> query = session.createQuery(hql, Participante.class);
			return query.list();
		} finally {
			session.close();
		}
	}

}