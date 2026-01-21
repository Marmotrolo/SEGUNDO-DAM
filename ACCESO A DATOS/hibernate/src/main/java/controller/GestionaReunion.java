package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.parser.ParseException;

import modelo.Acta;
import modelo.Persona;
import modelo.Reunion;
import modelo.Sala;
import repositorio.RepositorioActa;
import repositorio.RepositorioPersona;
import repositorio.RepositorioReunion;
import repositorio.RepositorioSala;


public class GestionaReunion {
	private static final Logger logger = LogManager.getLogger(GestionaReunion.class);
public static void main(String[] args) {
	
	RepositorioSala daoSala= new RepositorioSala();
	Sala nuevasala= new Sala();
	Sala nuevasala2= new Sala();

	RepositorioActa daoActa= new RepositorioActa();
	RepositorioPersona personaDao= new RepositorioPersona();
	RepositorioReunion daoReunion= new RepositorioReunion();
	
	Reunion nuevaReunion= new Reunion(nuevasala, LocalDateTime.now().plusDays(6), "Reunion futura");
	Reunion nuevaReunion2= new Reunion(nuevasala, LocalDateTime.now().plusDays(3), "Reunion nosecuales");

	Acta nuevaacta= new Acta(nuevaReunion,"El acta");
	Acta nuevaacta2= new Acta(nuevaReunion2,"El acta 2");
	
	nuevaReunion = daoReunion.mergeaObjeto(nuevaReunion);
	//Sincronizo nuevaReunion cargando su id

	Date fechaN = null;
	try {
		fechaN = new SimpleDateFormat("yyyy-MM-dd").parse("2000-11-04");
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	nuevaReunion = daoReunion.mergeaObjeto(nuevaReunion);
	//Sincronizo nuevaReunion cargando su id

	Persona p = new Persona("12345677p", "Pepa Rosa", 22,"rosaio@gmail.com", fechaN, "612345789");
	personaDao.create(p);

	//Creo la persona en la BBDD
	p.addReunion(nuevaReunion);
	personaDao.update(p);
	//Propago el cambio. En este momento se rellena la tabla intermedia.

	//Propago el cambio. En este momento se rellena la tabla intermedia.

	daoActa.create(nuevaacta);
	daoActa.create(nuevaacta2);
	

	List<Reunion> reuniones= daoReunion.getAll();
	
	for (Reunion reunion : reuniones) {
		logger.debug(reunion);
	}
}
}

