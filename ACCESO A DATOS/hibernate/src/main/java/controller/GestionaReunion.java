package controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Reunion;
import modelo.Sala;
import repositorio.RepositorioReunion;
import repositorio.RepositorioSala;


public class GestionaReunion {
	private static final Logger logger = LogManager.getLogger(GestionaReunion.class);
public static void main(String[] args) {
	RepositorioSala daoSala= new RepositorioSala();
	Sala nuevasala= new Sala();
	
	
	RepositorioReunion daoReunion= new RepositorioReunion();
	
	Reunion nuevaReunion= new Reunion(nuevasala, LocalDateTime.now().plusDays(3), "Reunion futura");

	daoReunion.create(nuevaReunion);
	List<Reunion> reuniones= daoReunion.getAll();
	
	for (Reunion reunion : reuniones) {
		logger.debug(reunion);
	}
}
}
