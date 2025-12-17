package dixitJDBC.controlador;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.modelos.Partida;
import dixitJDBC.modelos.Resultado;
import dixitJDBC.repositorio.RepositorioJugador;
import dixitJDBC.repositorio.RepositorioPartida;
import dixitJDBC.servicio.ServicioJugador;
import dixitJDBC.servicio.ServicioPartida;
import exceptions.MiExcepcion;

public class GestionaDixit {
	private static final Logger logger = LogManager.getLogger(RepositorioJugador.class);

	public static void main(String[] args) throws MiExcepcion, SQLException  {
			ServicioJugador servjugador= new ServicioJugador();
			ServicioPartida servpartida= new ServicioPartida();

			
			Jugador jugador1= new Jugador("eva", "eva@gmail", 4);
			Jugador jugador2= new Jugador("angela", "angela@gmail", 2);
			Jugador jugador3= new Jugador("carlos", "carlos@gmail", 1);
			Jugador jugador4= new Jugador("joseant", "joseant@gmail", 6);
			Jugador jugador5= new Jugador("puerto", "puerto@gmail", 3);
			Jugador jugador6= new Jugador("manuel", "manuel@gmail", 5);

			
			servjugador.insertarjugador(jugador1);
			servjugador.insertarjugador(jugador2);
			servjugador.insertarjugador(jugador3);
			servjugador.insertarjugador(jugador4); 
			servjugador.insertarjugador(jugador5);
			servjugador.insertarjugador(jugador6);
		
			
			List<Jugador> jugadoresbasededatos= servjugador.obtenerjugadores();
		
			Partida partida1= new Partida(1,jugadoresbasededatos.get(0), Date.valueOf("1999-12-30"), Resultado.NADIE);

			Partida partida2= new Partida(2,jugadoresbasededatos.get(2), Date.valueOf("1999-12-31"), Resultado.NADIE);
			Partida partida3= new Partida(3,jugadoresbasededatos.get(1), Date.valueOf("1999-12-20"), Resultado.TODOS);
			Partida partida4= new Partida(4,jugadoresbasededatos.get(3), Date.valueOf("1999-12-31"), Resultado.NADIE);
			Partida partida5= new Partida(5,jugadoresbasededatos.get(4), Date.valueOf("1999-12-09"), Resultado.NADIE); 
			Partida partida6= new Partida(6,jugadoresbasededatos.get(5), Date.valueOf("1999-12-10"), Resultado.ALGUNOS);

			servpartida.añadirpartida(partida6); 
			servpartida.añadirpartida(partida5); 
			servpartida.añadirpartida(partida4); 
			servpartida.añadirpartida(partida3); 
			servpartida.añadirpartida(partida2); 





	
		
		logger.info(servjugador.obtienejugadorconmayorpuntuacion());
		List<Jugador> jugadorese =servjugador.obtienenombresypuntuacionesordenadosdescendentemente();
		for (Jugador jugador : jugadorese) {
			logger.info(jugador.getNombre() +" "+  jugador.getPuntostotales());
		}
		servpartida.actualizapuntuacionnarrador(2, Resultado.ALGUNOS);
		servpartida.actualizapuntuacionnoacertante(4, Resultado.NADIE);
		servpartida.actualizarPuntuacionAcertante(1, Resultado.TODOS);
		
		List<Partida> partidasordenadasdescendientementeporfecha = servpartida.obtienepartidasporfechadescendiente();
		
		for (Partida partida : partidasordenadasdescendientementeporfecha) {
			logger.info(partida);
		}
		servjugador.delete(2);
}}
	
	
	


