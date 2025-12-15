package dixitJDBC.controlador;


import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.repositorio.RepositorioJugador;
import exceptions.MiExcepcion;

public class GestionaDixit {
	private static final Logger logger = LogManager.getLogger(RepositorioJugador.class);

public static void main(String[] args) {
	try {
		RepositorioJugador repo= new RepositorioJugador();
		Jugador jugador1= new Jugador("manue", "manuelparradotorres@gmail", 3);
		/*
		try {
			repo.insertarjugador(jugador1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		logger.info(repo.obtienejugadorconmayorpuntuacion());
	} catch (MiExcepcion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
