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
		
    	String consulta= "select * from dixitparrado.jugadores where id= ?"  ;
    	try {
    	Connection conexion= conector.getConnect();
    	PreparedStatement ps = conexion.prepareStatement(consulta);

    	ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			jugador= new Jugador(rs.getInt("id"),rs.getString("nombre"), rs.getString("email"), rs.getInt("puntosTotales"));
		}
		
    	
        conexion.close();
        
        
		} catch (SQLException e) {

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
	public int cuentapartidas() throws SQLException {
		String consulta= "select count(*) as total from dixitparrado.partidas";
		int partidascontadas=0;
    	Connection conexion;
			conexion = conector.getConnect();
			PreparedStatement ps;
			ps = conexion.prepareStatement(consulta);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			partidascontadas= rs.getInt("total");
			}
			// TODO Auto-generated catch block
		
    	
		  	return partidascontadas;
	}
			
	public void añadirpartida(Partida partida) throws MiExcepcion, SQLException {
		String consulta= "insert into dixitparrado.partidas(torneo_id,narrador_id,fecha,resultado) values(?,?,?,?)";
		PreparedStatement ps;
		if(cuentapartidas()<5) {
			Connection conexion= conector.getConnect();
			ps=conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
						int narradorIdAInsertar = partida.getNarrador_id().getId();
						logger.warn("Intentando insertar Partida con narrador_id: " + narradorIdAInsertar);
			ps.setInt(1,partida.getTorneo_id());			
			ps.setInt(2, partida.getNarrador_id().getId());
			ps.setDate(3, partida.getFecha());
			ps.setString(4, partida.getResultado().name());
			ps.executeUpdate();

	    	ResultSet rs= ps.getGeneratedKeys();
	    	if(rs.next()) {
	    		partida.setId(rs.getInt(1));
	    	}
			logger.info("Partida aÃ±adida " + partida.getId());

			partidas.add(partida);


		}

		else {
			throw new MiExcepcion("ERROR: No puede haber mas de 5 partidas");
		}
}

	public void actualizapuntuacionnarrador(int id, Resultado resultado) throws SQLException {
		String consulta= "update dixitparrado.jugadores set puntosTotales= puntosTotales +3 where id= ?";

		Connection conexion= conector.getConnect();
		PreparedStatement ps= conexion.prepareStatement(consulta);
		ps.setInt(1, id);
		
		if(resultado.equals(Resultado.ALGUNOS)) {
			ps.executeUpdate();
			logger.info("Puntos actualizados + 3");
		}
		
	}
	public void actualizapuntuacionnoacertante(int id, Resultado resultado) throws SQLException {
		String consulta= "update dixitparrado.jugadores set puntosTotales= puntosTotales +2 where id= ?";

		Connection conexion= conector.getConnect();
		PreparedStatement ps= conexion.prepareStatement(consulta);
		ps.setInt(1, id);
		
		if(resultado.equals(Resultado.TODOS)|| resultado.equals(Resultado.NADIE)) {
			ps.executeUpdate();
			logger.info("Puntos actualizados + 2");
		}
		
	}
	public void actualizarPuntuacionAcertante (int id, Resultado resultado) throws SQLException {

		Connection conexion= conector.getConnect();
		
		if(resultado.equals(Resultado.TODOS)|| resultado.equals(Resultado.NADIE)) {
			actualizapuntuacionnoacertante(id, resultado);
		}
		else if (resultado.equals(Resultado.ALGUNOS)) {
			actualizapuntuacionnarrador(id, resultado);
		}
		
	}

	public List<Partida> obtienepartidasporfechadescendiente() throws SQLException, MiExcepcion{
		
		List<Partida> partidas=new ArrayList<>();
		Connection conexion = conector.getConnect();
		
		String consulta= "select * from dixitparrado.partidas order by fecha desc";
		
		PreparedStatement ps= conexion.prepareStatement(consulta);
		ResultSet rs= ps.executeQuery();
		
		while (rs.next()) {

			Partida p = new Partida();

			p.setId(rs.getInt("id"));

			p.setTorneo_id(rs.getInt("torneo_id"));

			p.setNarrador_id(this.getnarradorporid(rs.getInt("narrador_id")));

			p.setFecha(rs.getDate("fecha"));

			p.setResultado(Resultado.valueOf(rs.getString("resultado")));

			partidas.add(p);

		}
		return partidas;
		
		
		
	}
	
	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	
}
