package dixitJDBC.servicio;


import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.repositorio.RepositorioJugador;
import dixitJDBC.repositorio.RepositorioPartida;
import exceptions.MiExcepcion;

public class ServicioJugador {
	private static final Logger logger = LogManager.getLogger(RepositorioPartida.class);

	  private final RepositorioJugador repojugador;
	  
	  
	  public ServicioJugador() throws MiExcepcion, SQLException {
		super();
		this.repojugador = new RepositorioJugador();
	  }


	  public List<Jugador> obtenerjugadores(){
		  return repojugador.getJugadores();
	  }
	  
	  public Jugador obtenerjugadorporid(int id) {
		  Jugador jugador=null;
			 try {
				jugador= repojugador.obtenerjugadorporid(id);
			} catch (MiExcepcion | SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		
		  return jugador;
	  }
	   
		public void insertarjugador(Jugador jugador){
			try {
				repojugador.insertarjugador(jugador);
			} catch (MiExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public  void delete(int id ) {
			try {
				repojugador.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}
		public Jugador obtienejugadorconmayorpuntuacion() {
			Jugador jugador=null;
			try {
				jugador=repojugador.obtienejugadorconmayorpuntuacion();
			} catch (MiExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jugador;
		}
		public List<Jugador>  obtienenombresypuntuacionesordenadosdescendentemente(){
			List<Jugador> listajugadores= null;
			
			try {
				return listajugadores= repojugador.obtienenombresypuntuacionesordenadosdescendentemente();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listajugadores;
		}
}
	   

