package dixitJDBC.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.modelos.Partida;
import dixitJDBC.modelos.Resultado;
import dixitJDBC.utiles.MySqlConector;
import exceptions.MiExcepcion;


public class RepositorioJugador {
	private static final Logger logger = LogManager.getLogger(RepositorioJugador.class);
	List<Jugador> jugadores;
	private MySqlConector conector;

	public RepositorioJugador() throws MiExcepcion, SQLException {
		super();
		this.conector = new MySqlConector();
		this.jugadores= this.cargarjugadores();
	}
	private List<Jugador> cargarjugadores() throws SQLException, MiExcepcion {

		List<Jugador> lista = new ArrayList<>();

		Connection conexion = conector.getConnect();


		String sql = "SELECT * FROM dixitparrado.jugadores";
    	PreparedStatement ps = conexion.prepareStatement(sql);

		ResultSet resul = ps.executeQuery(sql);

		while (resul.next()) {

			Jugador j = new Jugador(resul.getInt("id"),resul.getString("nombre"), resul.getString("email"), resul.getInt("puntosTotales"));
			lista.add(j);

		}

		return lista;

	}
	
	public void delete(int id ) throws SQLException {
		String consulta= "delete from dixitparrado.jugadores where id =?";
	    
			Connection conexion= conector.getConnect();
	    	PreparedStatement ps = conexion.prepareStatement(consulta);	
	    	ps.setInt(1, id);

	    	ps.executeUpdate();
	    	
	    	logger.info("Jugador eliminado con id " + id);
	
	}
	
	
	public Jugador obtenerjugadorporid(int id ) throws MiExcepcion, SQLException {
		  /*-- Esta consulta combina la información de las tablas Estudiantes y Direcciones para filtrar por la ciudad.
		SELECT E.nombre, E.notaMedia, D.ciudad
		FROM Estudiantes E
		JOIN Direcciones D ON E.direccion_id = D.id
		WHERE D.ciudad = 'Sevilla'
		ORDER BY E.nombre DESC;*/
		Jugador jugadordevuelve = null;
    	String consulta= "select * from dixitparrado.jugadores where id =?";
    
			Connection conexion= conector.getConnect();
	    	PreparedStatement ps = conexion.prepareStatement(consulta);
	    	ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				jugadordevuelve= new Jugador(rs.getInt("id"),rs.getString("nombre"), rs.getString("email"), rs.getInt("puntosTotales"));
			}
			
	    	
            
            else {
			// TODO Auto-generated catch block
			throw new MiExcepcion("Error: No se ha podido obtener");
            }
            conexion.close();

        return jugadordevuelve;

	}
	
	
	
	public void insertarjugador(Jugador jugador) throws MiExcepcion, SQLException {
		//AÃ±adiendo un nuevo elemento a la BBDD con otra manera de conexiÃ³n			 
	    
		/*
			 -- Esta consulta se utiliza para filtrar estudiantes basándose en un valor que se proporciona externamente (representado aquí por ? o un marcador de posición).
			SELECT nombre, notaMedia
			FROM Estudiantes
			WHERE notaMedia < 2;
		*/
		 
	    	String consulta= "insert into dixitparrado.jugadores (nombre,email,puntostotales) values (?,?,?)";
	    	Connection conexion= conector.getConnect();

	    	PreparedStatement ps;
			try {
				ps = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			  	
		    	ps.setString(1, jugador.getNombre());
		    	ps.setString(2, jugador.getEmail());
		    	ps.setInt(3, jugador.getPuntostotales());
		    	
		    	ps.executeUpdate();
		    	
		    	ResultSet rs= ps.getGeneratedKeys();
		    	if(rs.next()) {
		    		jugador.setId(rs.getInt(1));
		    	}
		    	jugadores.add(jugador);

		    	logger.info("Jugador aÃ±adido: " + jugador.getNombre());
		    	
	            conexion.close();
	            
	            
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MiExcepcion("Error: " + e.getMessage());
			}
	    	
	    }
	
	public Jugador obtienejugadorconmayorpuntuacion() throws MiExcepcion {
		/*-- Esta consulta utiliza la función de agregación AVG() para calcular la media de las puntuaciones de cada estudiante.
SELECT E.nombre, AVG(S.puntuacion) AS score_medio
FROM Estudiantes E
JOIN Scores S ON E.id = S.estudiante_id
GROUP BY E.id, E.nombre;*/
		//AÃ±adiendo un nuevo elemento a la BBDD con otra manera de conexiÃ³n			 
		Jugador jugadordevuelve = null;
	    	String consulta= "select * from dixitparrado.jugadores order by puntosTotales desc limit 1;";
	    
			try {
				Connection conexion= conector.getConnect();
		    	PreparedStatement ps = conexion.prepareStatement(consulta);

				ResultSet rs= ps.executeQuery(consulta);
				
				if(rs.next()) {
					jugadordevuelve= new Jugador(rs.getInt("id"),rs.getString("nombre"), rs.getString("email"), rs.getInt("puntosTotales"));
				}
				
		    	
		    
		    	
	            conexion.close();
	            
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MiExcepcion("Error: " + e.getMessage());
			}
            return jugadordevuelve;

	    }
	
	public List<Jugador> obtienenombresypuntuacionesordenadosdescendentemente() throws SQLException{
		List<Jugador> jugadores= new ArrayList<>();
    	String consulta= "select nombre, puntosTotales from dixitparrado.jugadores order by puntosTotales desc;";
    	/*-- Esta consulta utiliza la función COUNT() y agrupa los resultados por estudiante y por el tipo de puntuación (tipo).
    	SELECT E.nombre, S.tipo, COUNT(S.id) AS numero_puntuaciones
    	FROM Estudiantes E
    	JOIN Scores S ON E.id = S.estudiante_id
    	GROUP BY E.id, E.nombre, S.tipo
    	ORDER BY E.nombre, S.tipo;*/
  
			Connection conexion= conector.getConnect();
			PreparedStatement ps= conexion.prepareStatement(consulta);
			ResultSet rs= ps.executeQuery(consulta);
			
			while(rs.next()) {
				jugadores.add(new Jugador(rs.getString("nombre"), rs.getInt("puntosTotales")));
			}
			conexion.close();
		
			// TODO Auto-generated catch block
			return jugadores	;

		}

	
	public List<Jugador> getJugadores() {
	
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
