package utiles;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.TypedQuery;

public abstract class AbstractDao<T> implements IDao<T> {
	private Class<T> clase;

	@Override
	public void create(T t) {
		executeInsideTransaction(t);
	}

	public void refresh(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.refresh(t);
	}

	public T mergeaObjeto(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.merge(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

		return t;
	}

	@Override
	public T get(int id) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return sesion.find(clase, id);
	}

	@Override
	public List<T> getAll() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + clase.getName();
		TypedQuery<T> query = sesion.createQuery(queryString, clase);
		List<T> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public void update(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		executeInsideTransaction(sesion, sesion.merge(t));
	}

	@Override
	public void delete(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.remove(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

	}

	private void executeInsideTransaction(Session sesion, T objecto) {
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.persist(objecto);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	private void executeInsideTransaction(T objecto) {
		executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objecto);
	}

	/**
	 * @return the clase
	 */
	public Class<T> getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}
	/*-- Obtiene todos los jugadores de un equipo espec�fico por su nombre
SELECT j FROM Jugador j WHERE j.equipo.nombre = :nombreEquipo

-- Selecciona los equipos ordenados por puntos de forma descendente
FROM Equipo e ORDER BY e.puntosAcumulados DESC

SELECT f.equipos FROM Fase f WHERE f.nombreFase = :nombreFase

FROM Jugador j WHERE j.dni = :dni

*SELECT art FROM Articulo art 
JOIN art.autores aut 
WHERE aut.nombre = :nombreAutor 
ORDER BY art.titulo ASC

SELECT art.titulo, (art.numPaginaFin - art.numPaginaInicio) 
FROM Articulo art 
WHERE (art.numPaginaFin - art.numPaginaInicio) > 6

SELECT r.nombreRevista, COUNT(a) 
FROM Revista r 
JOIN r.articulos a 
GROUP BY r.idRevista, r.nombreRevista

SELECT r.nombreRevista, r.fecha, r.numeroRevista 
FROM Revista r 
WHERE r.fecha < :fechaLimite*/
}
