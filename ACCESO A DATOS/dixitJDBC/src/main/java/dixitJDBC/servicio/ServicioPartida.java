package dixitJDBC.servicio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.modelos.Partida;
import dixitJDBC.modelos.Resultado;
import dixitJDBC.repositorio.RepositorioPartida;
import exceptions.MiExcepcion;

public class ServicioPartida {
	private static final Logger logger = LogManager.getLogger(RepositorioPartida.class);

	private final RepositorioPartida repoPartida;
	  
	  
	  public ServicioPartida() throws MiExcepcion, SQLException {
		super();
		this.repoPartida = new RepositorioPartida();
	  }
	  
	  public List<Partida> getnarradorporid(int id) {
		
		  List<Partida> partidas=null;
		  
		  return partidas= repoPartida.getPartidas();
	  }
	  public int cuentapartidas() {
		  int partidas=0;
		  
		  try {
			partidas= repoPartida.cuentapartidas();
		} catch (SQLException e) {

			logger.error(e.getMessage());
		}
		  return partidas;
	  }
	  public void añadirpartida(Partida partida){
			try {
				repoPartida.añadirpartida(partida);
			} catch (MiExcepcion | SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		 
	  
	  }
	  
	  public void actualizapuntuacionnarrador(int id , Resultado resultado) {
		  
		  try {
			repoPartida.actualizapuntuacionnarrador(id, resultado);
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		  }
		  
	  }
public void actualizapuntuacionnoacertante(int id , Resultado resultado) {
		  
		  try {
			repoPartida.actualizapuntuacionnoacertante(id, resultado);
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		  }
		  
	  }
public void actualizarPuntuacionAcertante(int id , Resultado resultado) {
	  
	  try {
		repoPartida.actualizarPuntuacionAcertante(id, resultado);
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.error(e.getMessage());
	  }
	  
}
public List<Partida>obtienepartidasporfechadescendiente(){
	List<Partida> partidas=new ArrayList<>();
	try {
		partidas=repoPartida.obtienepartidasporfechadescendiente();
	} catch (SQLException | MiExcepcion e) {
		// TODO Auto-generated catch block
		logger.info(e.getMessage());;
	}
	return partidas;
	
}

}
