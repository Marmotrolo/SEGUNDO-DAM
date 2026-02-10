package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tiendainformatica.dao.RepositorioCategoriaDAO;
import tiendainformatica.dao.RepositorioClienteDAO;
import tiendainformatica.dao.RepositorioEmpleadoDAO;
import tiendainformatica.dao.RepositorioFabricanteDAO;
import tiendainformatica.dao.RepositorioGarantiaDAO;
import tiendainformatica.dao.RepositorioProductoDAO;
import utiles.HibernateUtil;

public class TiendaService {

	private RepositorioProductoDAO productoDAO;
	private RepositorioClienteDAO clienteDAO;
	private RepositorioCategoriaDAO categoriaDAO;
	private RepositorioFabricanteDAO fabricanteDAO;
	private RepositorioGarantiaDAO garantiaDAO;
	private RepositorioEmpleadoDAO empleadoDAO;

	private SessionFactory factory;

	public TiendaService() {
		this.factory = HibernateUtil.getFactoriaSession();

		this.productoDAO = new RepositorioProductoDAO();

		this.clienteDAO = new RepositorioClienteDAO();

		this.categoriaDAO = new RepositorioCategoriaDAO();

		this.fabricanteDAO = new RepositorioFabricanteDAO();

		this.garantiaDAO = new RepositorioGarantiaDAO();

		this.empleadoDAO = new RepositorioEmpleadoDAO();
	}

	public RepositorioProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void guardar(Object objeto) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(objeto);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void eliminar(Object objeto) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.remove(objeto);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}


}
