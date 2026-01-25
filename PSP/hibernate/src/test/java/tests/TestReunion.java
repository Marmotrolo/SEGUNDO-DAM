package tests;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import modelo.Reunion;
import utils.HibernateUtil;

public class TestReunion {
	private static final Logger logger = LogManager.getLogger(TestReunion.class);

	@Test
	void testCreateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		//Registramos una transacción
		sesion.beginTransaction();
			
		
		Reunion reunion = new Reunion();
		reunion.setAsunto("asunto");
		reunion.setFecha(LocalDateTime.now());
		sesion.persist(reunion);
		sesion.getTransaction().commit();
		sesion.close();	
	}
	@Test
		void testRetrieveReunion() {
			Session sesion = HibernateUtil.getFactoriaSession().openSession();
			Reunion r = sesion.find(Reunion.class, 1);
			logger.debug("El asunto es:"+r.getAsunto());
			sesion.close();
		}/*
	@Test
	void testUpdateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		Reunion r = sesion.find(Reunion.class, 1);
		sesion.beginTransaction();
		r.setAsunto("Nuevo Asunto --");
		sesion.getTransaction().commit();
		sesion.close();
	}
	@Test
	void testDeleteReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.beginTransaction();
		sesion.remove(sesion.find(Reunion.class, 2));
		sesion.getTransaction().commit();
		sesion.close();	
	}*/



	


}
