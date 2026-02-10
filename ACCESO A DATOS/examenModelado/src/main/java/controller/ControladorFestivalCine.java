package controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import modelo.Cine;
import modelo.Pelicula;
import modelo.Sala;

import service.ServiceFestivalCine;

public class ControladorFestivalCine {
	private static final Logger logger = LogManager.getLogger(ControladorFestivalCine.class);

	public static void main(String[] args) {
		ServiceFestivalCine serviciofc = new ServiceFestivalCine();
		
		Pelicula p1 = new Pelicula("Pelicula1", "guay", 3);
		serviciofc.getPeliculaDAO().create(p1);;
		Pelicula p2 = new Pelicula("Pelicula2", "ficcion", 2);
		serviciofc.getPeliculaDAO().create(p2);;
		Pelicula p3 = new Pelicula("Pelicula3", "accion", 1);
		serviciofc.getPeliculaDAO().create(p3);;
		Pelicula p4 = new Pelicula("Pelicula4", "romance", 2);
		serviciofc.getPeliculaDAO().create(p4);;
		Pelicula p5 = new Pelicula("Pelicula5", "suspense", 4);
		serviciofc.getPeliculaDAO().create(p5);;

		Sala s1 = new Sala("sala1", 50);
		Sala s2 = new Sala("sala2", 40);
		Sala s3 = new Sala("sala3", 30);
		Sala s4 = new Sala("sala4", 60);
		s1.addPelicula(p1);
		s1.addPelicula(p2);
		s2.addPelicula(p2);
		s2.addPelicula(p4);
		s3.addPelicula(p5);
		s4.addPelicula(p3);
	

		Cine c1 = new Cine("Cine 1", "Al lao de mi casa");
		Cine c2 = new Cine("Cine 2", "No esta al lao de mi casa");
		c1.addSala(s2);
		c1.addSala(s4);
		c2.addSala(s1);
		c2.addSala(s3);
		serviciofc.getCineDAO().create(c1);
		serviciofc.getCineDAO().create(c2);

		
		serviciofc.getCineDAO().mergeaObjeto(c1);
		serviciofc.getCineDAO().mergeaObjeto(c2);


		List<Pelicula> peliculas = serviciofc.getPeliculaDAO().getAll();
		for (Pelicula p : peliculas) {
			logger.debug(p);
		}

		List<Sala> salas = serviciofc.getSalaDAO().getAll();
		for (Sala s : salas) {
			logger.debug(s);
		}

	}

}
