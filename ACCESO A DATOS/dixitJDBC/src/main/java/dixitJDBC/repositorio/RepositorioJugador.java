package dixitJDBC.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.utiles.MySqlConector;
import exceptions.MiExcepcion;


public class RepositorioJugador {
	private static final Logger logger = LogManager.getLogger(RepositorioJugador.class);
	
	private MySqlConector conector;

	public RepositorioJugador() throws MiExcepcion {
		super();
		this.conector = new MySqlConector();
	}
	
	
	public void insertarjugador(Jugador jugador) throws MiExcepcion, SQLException {
		//Añadiendo un nuevo elemento a la BBDD con otra manera de conexión			 
	    
	    	String consulta= "insert into dixitparrado.jugadores (nombre,email,puntostotales) values (?,?,?)";
	    	Connection conexion= conector.getConnect();
	    	PreparedStatement ps;
			try {
				ps = conexion.prepareStatement(consulta);
			  	
		    	ps.setString(1, jugador.getNombre());
		    	ps.setString(2, jugador.getEmail());
		    	ps.setInt(3, jugador.getPuntostotales());
		    	
		    	ps.executeUpdate();
		    	
		    	logger.info("Jugador añadido: " + jugador.getNombre());
		    	
	            conexion.close();
	            
	            
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MiExcepcion("Error: " + e.getMessage());
			}
	    }
	
	public Jugador obtienejugadorconmayorpuntuacion() throws MiExcepcion {
		//Añadiendo un nuevo elemento a la BBDD con otra manera de conexión			 
		Jugador jugadordevuelve = null;
	    	String consulta= "select * from dixitparrado.jugadores order by puntosTotales desc limit 1;";
	    
			try {
				Connection conexion= conector.getConnect();
		    	PreparedStatement ps = conexion.prepareStatement(consulta);

				ResultSet rs= ps.executeQuery(consulta);
				
				if(rs.next()) {
					jugadordevuelve= new Jugador(rs.getString("nombre"), rs.getString("email"), rs.getInt("puntosTotales"));
				}
				
		    	
		    
		    	
	            conexion.close();
	            
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MiExcepcion("Error: " + e.getMessage());
			}
            return jugadordevuelve;

	    }
	
}