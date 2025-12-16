package dixitJDBC.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dixitJDBC.modelos.Jugador;
import dixitJDBC.modelos.Partida;
import dixitJDBC.modelos.Resultado;
import dixitJDBC.utiles.MySqlConector;
import exceptions.MiExcepcion;

public class RepositorioPartida {
private static final Logger logger = LogManager.getLogger(RepositorioPartida.class);
	
	private MySqlConector conector;
	private List<Partida> partidas;
	public RepositorioPartida() throws MiExcepcion, SQLException {
		super();
		this.conector = new MySqlConector();
		this.partidas= this.cargar();
	}
	
	private Jugador getnarradorporid(int id) throws MiExcepcion {
		Jugador jugador=null;
		
    	String consulta= "select * from dixitparrado.jugadores where id= " +id ;
    	try {
    	Connection conexion= conector.getConnect();
    	PreparedStatement ps = conexion.prepareStatement(consulta);

		ResultSet rs= ps.executeQuery(consulta);
		
		if(rs.next()) {
			jugador= new Jugador(rs.getInt("id"),rs.getString("nombre"), rs.getString("email"), rs.getInt("puntosTotales"));
		}
		
    	
        conexion.close();
        
        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MiExcepcion("Error: " + e.getMessage());
		}
        return jugador;

    }
	
	private List<Partida> cargar() throws SQLException, MiExcepcion {

		List<Partida> lista = new ArrayList<>();

		Connection conexion = conector.getConnect();


		String sql = "SELECT * FROM dixitparrado.partidas";
    	PreparedStatement ps = conexion.prepareStatement(sql);

		ResultSet resul = ps.executeQuery(sql);

		while (resul.next()) {

			Partida p = new Partida();

			p.setId(resul.getInt("id"));

			p.setTorneo_id(resul.getInt("torneo_id"));

			p.setNarrador_id(this.getnarradorporid(resul.getInt("narrador_id")));

			p.setFecha(resul.getDate("fecha"));

			p.setResultado(Resultado.valueOf(resul.getString("resultado")));



			lista.add(p);

		}

		return lista;

	}
	public int cuentapartidas() {
		String consulta= "select count(*) as total from dixitparrado.partidas";
		int partidascontadas=0;
    	Connection conexion;
		try {
			conexion = conector.getConnect();
			PreparedStatement ps;
			ps = conexion.prepareStatement(consulta);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			partidascontadas= rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		  	return partidascontadas;
	}
		
	
	
	public void añadirpartida(Partida partida) throws MiExcepcion {
		String consulta= "insert into dixitparrado.partidas(narrador_id,fecha) values(?,?)";
		PreparedStatement ps;
		if(cuentapartidas()<5) {
		try {
			Connection conexion= conector.getConnect();
			ps=conexion.prepareStatement(consulta);
			ps.setInt(1, partida.getNarrador_id().getId());
			ps.setDate(2, partida.getFecha());
			ps.executeUpdate();
			
			logger.info("Partida añadida" + partida.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		else {
			throw new MiExcepcion("ERROR: No puede haber más de 5 partidas");
		}
		
		partidas.add(partida);
	}
	
	public void actualizapuntuacionnarrador(int id, Resultado resultado) {
	
	}
	
}
