package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CineDAO;
import dao.PeliculaDAO;
import dao.SalaDAO;

import utiles.HibernateUtil;

public class ServiceFestivalCine {

	private CineDAO cineDAO;
	private PeliculaDAO peliculaDAO;
	private SalaDAO salaDAO;

	private SessionFactory factory;

	

	

	public ServiceFestivalCine() {
		this.factory = HibernateUtil.getFactoriaSession();
		this.cineDAO = new CineDAO();
		this.peliculaDAO = new PeliculaDAO();
		this.salaDAO = new SalaDAO();
	}





	public CineDAO getCineDAO() {
		return cineDAO;
	}





	public void setCineDAO(CineDAO cineDAO) {
		this.cineDAO = cineDAO;
	}





	public PeliculaDAO getPeliculaDAO() {
		return peliculaDAO;
	}





	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}





	public SalaDAO getSalaDAO() {
		return salaDAO;
	}





	public void setSalaDAO(SalaDAO salaDAO) {
		this.salaDAO = salaDAO;
	}





	public SessionFactory getFactory() {
		return factory;
	}





	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	


}
