package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Evento;
import modelos.Participante;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class EventoDao extends AbstractDao<Evento> {

	public EventoDao() {
		setClase(Evento.class);
	}
	
	public List<Object[]> obtenereventosqueduranmasde91min() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT e.nombre, e.tipoEvento, e.duracion FROM Evento e WHERE e.duracion>91 ";
			Query<Object[]> query = session.createQuery(hql, Object[].class);
			return query.list();
		} finally {
			session.close();
		}
	}
		public List<Evento> obtenereventosporubicacion(String ubicacion){
			Session session = HibernateUtil.getFactoriaSession().openSession();
			try {
				String hql = "FROM Evento e WHERE e.ubicacion.nombre = :ubicacion";
				Query<Evento> query = session.createQuery(hql, Evento.class);
				query.setParameter("ubicacion",  ubicacion );
				return query.list();
			} finally {
				session.close();
			}
		}
	}
