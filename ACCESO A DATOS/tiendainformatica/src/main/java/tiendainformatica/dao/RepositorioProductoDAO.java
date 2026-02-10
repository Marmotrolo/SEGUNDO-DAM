package tiendainformatica.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import tiendainformatica.model.Producto;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class RepositorioProductoDAO extends AbstractDao<Producto> {

	public RepositorioProductoDAO() {
		setClase(Producto.class);
	}

	public Producto obtenerProductoMasCaro() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Producto p ORDER BY p.precio DESC";
			Query<Producto> query = session.createQuery(hql, Producto.class);
			query.setMaxResults(1);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public List<String> obtenerNombresProductos() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT p.nombre FROM Producto p";
			Query<String> query = session.createQuery(hql, String.class);
			return query.list();
		} finally {
			session.close();
		}
	}

	public List<Object[]> obtenerNombreYPrecioProductos() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT p.nombre, p.precio FROM Producto p";
			Query<Object[]> query = session.createQuery(hql, Object[].class);
			return query.list();
		} finally {
			session.close();
		}
	}

	public List<Producto> buscarPorPrecioMenorIgual(Double precioMax) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Producto p WHERE p.precio <= :precioMax";
			Query<Producto> query = session.createQuery(hql, Producto.class);
			query.setParameter("precioMax", precioMax);
			return query.list();
		} finally {
			session.close();
		}
	}

	public List<Producto> buscarPorNombreParcial(String textoBusqueda) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:busqueda)";
			Query<Producto> query = session.createQuery(hql, Producto.class);
			query.setParameter("busqueda", "%" + textoBusqueda + "%");
			return query.list();
		} finally {
			session.close();
		}
	}

	public Double calcularPrecioPromedio() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT AVG(p.precio) FROM Producto p";
			Query<Double> query = session.createQuery(hql, Double.class);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public Double calcularPrecioPromedioPorCategoria(Long categoriaId) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT AVG(p.precio) FROM Producto p WHERE p.categoria.id = :categoriaId";
			Query<Double> query = session.createQuery(hql, Double.class);
			query.setParameter("categoriaId", categoriaId);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public Long contarProductos() {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT COUNT(p) FROM Producto p";
			Query<Long> query = session.createQuery(hql, Long.class);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public Long contarProductosPorFabricante(Long fabricanteId) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "SELECT COUNT(p) FROM Producto p WHERE p.fabricante.id = :fabricanteId";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("fabricanteId", fabricanteId);
			return query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public List<Producto> obtenerProductosPorCategoriaOrdenadosPorPrecio(Long categoriaId) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Producto p WHERE p.categoria.id = :categoriaId ORDER BY p.precio ASC";
			Query<Producto> query = session.createQuery(hql, Producto.class);
			query.setParameter("categoriaId", categoriaId);
			return query.list();
		} finally {
			session.close();
		}
	}

	public List<Producto> obtenerProductosPorRangoPrecioOrdenados(Double precioMin, Double precioMax) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			String hql = "FROM Producto p WHERE p.precio BETWEEN :precioMin AND :precioMax ORDER BY p.precio DESC";
			Query<Producto> query = session.createQuery(hql, Producto.class);
			query.setParameter("precioMin", precioMin);
			query.setParameter("precioMax", precioMax);
			return query.list();
		} finally {
			session.close();
		}
	}

	public int actualizarPrecioConCriteria(Long id, Double nuevoPrecio) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaUpdate<Producto> update = cb.createCriteriaUpdate(Producto.class);
			Root<Producto> root = update.from(Producto.class);

			update.set(root.get("precio"), nuevoPrecio);
			update.where(cb.equal(root.get("id"), id));

			int resultado = session.createMutationQuery(update).executeUpdate();
			session.getTransaction().commit();
			return resultado;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int aplicarDescuentoPorCategoriaConCriteria(Long categoriaId, Double porcentajeDescuento) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaUpdate<Producto> update = cb.createCriteriaUpdate(Producto.class);
			Root<Producto> root = update.from(Producto.class);

			update.set("precio", cb.prod(root.get("precio"), 1 - porcentajeDescuento / 100));

			update.where(cb.equal(root.get("categoria").get("id"), categoriaId));

			int resultado = session.createQuery(update).executeUpdate();

			tx.commit();
			return resultado;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int eliminarProductosCarosConCriteria(Double precioMaximo) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaDelete<Producto> delete = cb.createCriteriaDelete(Producto.class);
			Root<Producto> root = delete.from(Producto.class);

			delete.where(cb.greaterThan(root.get("precio"), precioMaximo));

			int resultado = session.createMutationQuery(delete).executeUpdate();
			session.getTransaction().commit();
			return resultado;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int eliminarProductosPorFabricanteConCriteria(Long fabricanteId) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaDelete<Producto> delete = cb.createCriteriaDelete(Producto.class);
			Root<Producto> root = delete.from(Producto.class);

			delete.where(cb.equal(root.get("fabricante").get("id"), fabricanteId));

			int resultado = session.createMutationQuery(delete).executeUpdate();
			session.getTransaction().commit();
			return resultado;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Producto> buscarPorRangoPrecioConCriteria(Double precioMin, Double precioMax) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
			Root<Producto> root = cq.from(Producto.class);

			cq.select(root).where(cb.and(cb.greaterThanOrEqualTo(root.get("precio"), precioMin),
					cb.lessThanOrEqualTo(root.get("precio"), precioMax)));
			cq.orderBy(cb.asc(root.get("precio")));

			return session.createQuery(cq).getResultList();
		} finally {
			session.close();
		}
	}
}
