package dixitJDBC.controlador;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.modelos.Partida;
import dixitJDBC.modelos.Resultado;
import dixitJDBC.repositorio.RepositorioJugador;
import dixitJDBC.repositorio.RepositorioPartida;
import exceptions.MiExcepcion;

public class GestionaDixit {
	private static final Logger logger = LogManager.getLogger(RepositorioJugador.class);

public static void main(String[] args) throws SQLException {
	try {
		RepositorioJugador repo= new RepositorioJugador();
		RepositorioPartida repopartida= new RepositorioPartida();

		Jugador jugador1= new Jugador("eva", "eva@gmail", 4);
		logger.info(jugador1.getId());
		Jugador jugador2= new Jugador("angela", "angela@gmail", 2);
		Jugador jugador3= new Jugador("carlos", "carlos@gmail", 1);
		Jugador jugador4= new Jugador("joseant", "joseant@gmail", 6);
		Jugador jugador5= new Jugador("puerto", "puerto@gmail", 3);
		Jugador jugador6= new Jugador("manuel", "manuel@gmail", 5);

		
		Partida partida1= new Partida(1,jugador1, Date.valueOf("1999-12-31"), Resultado.ALGUNOS);
		Partida partida2= new Partida(2,jugador3, Date.valueOf("1999-12-31"), Resultado.NADIE);
		Partida partida3= new Partida(3,jugador5, Date.valueOf("1999-12-31"), Resultado.TODOS);
		Partida partida4= new Partida(4,jugador2, Date.valueOf("1999-12-31"), Resultado.NADIE);
		Partida partida5= new Partida(5,jugador4, Date.valueOf("1999-12-31"), Resultado.NADIE);
		Partida partida6= new Partida(6,jugador2, Date.valueOf("1999-12-31"), Resultado.ALGUNOS);


		
			/*try {
				repo.insertarjugador(jugador1);
				repo.insertarjugador(jugador2);
				repo.insertarjugador(jugador3);
				repo.insertarjugador(jugador4);
				repo.insertarjugador(jugador5);
				repo.insertarjugador(jugador6);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			repopartida.añadirpartida(partida1);

			//repopartida.añadirpartida(partida5);



		/*} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		logger.info(repo.obtienejugadorconmayorpuntuacion());
		List<Jugador> jugadores =repo.obtienenombresypuntuacionesordenadosdescendentemente();
		for (Jugador jugador : jugadores) {
			logger.info(jugador.getNombre() +" "+  jugador.getPuntostotales());
		}
	} catch (MiExcepcion e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}}
	
	
	


