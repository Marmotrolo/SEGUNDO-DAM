package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import modelo.AppException;
import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;
import utiles.MySqlConector;

public class UsuarioRepositorio {
	private static final Logger logger = LogManager.getLogger(UsuarioRepositorio.class);
	List<Usuario> usuarios;
	private MySqlConector conector;
	
	public UsuarioRepositorio() throws AppException, SQLException {
		super();
		this.usuarios = this.cargarusuarios();
		this.conector = new MySqlConector();
	}
	
	public Preferencias getpreferenciaporid(String id) throws AppException {
		Preferencias preferencia=null;
		
    	String consulta= "select * from parradomanuel.preferencias where usuario_id= ?"  ;
    	try {
    	Connection conexion= conector.getConnect();
    	PreparedStatement ps = conexion.prepareStatement(consulta);

    	ps.setString(1, id);
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			Preferencias p= new Preferencias(rs.getBoolean("tema_oscuro"), rs.getString("idioma"), rs.getBoolean("notificaciones_push"),rs.getBoolean("limite_datos_moviles"));
			preferencia=p;
		}
		
    	
        conexion.close();
        
        
		} catch (SQLException e) {

			throw new AppException("Error: " + e.getMessage());
		}
        return preferencia;

    }
	public List<Usuario> cargarusuarios() throws SQLException, AppException {

		List<Usuario> listausuarios = new ArrayList<>();
		
		if(this.conector== null) {

		this.conector= new MySqlConector();
		}
		Connection conexion= this.conector.getConnect();

		String sql = "SELECT * FROM parradomanuel.usuarios";
    	PreparedStatement ps = conexion.prepareStatement(sql);

		ResultSet resul = ps.executeQuery(sql);


			while (resul.next()) {

				Usuario u = new Usuario();

				u.setId(resul.getString("id"));

				u.setUsername(resul.getString("username"));

				u.setEmail(resul.getString("email"));

				u.setPlan_activo(PlanActivo.valueOf(resul.getString("plan_activo")));

				u.setDispositivo(resul.getString("dispositivo"));
				

				listausuarios.add(u);

			}			
		

		return listausuarios;

	}
	
	public List<Usuario> cargarusuariosporplanactivo(PlanActivo plan_activo) throws SQLException, AppException {

		List<Usuario> listausuarios = new ArrayList<>();
		
		if(this.conector== null) {

		this.conector= new MySqlConector();
		}
		Connection conexion= this.conector.getConnect();
		
String planactivoString= plan_activo.name();

		System.out.println(planactivoString);
		String sql = "SELECT email,dispositivo FROM parradomanuel.usuarios where plan_activo= ? "    ;
    	PreparedStatement ps = conexion.prepareStatement(sql);
logger.info(sql);
    	ps.setString(1, planactivoString);
    	if(planactivoString.equals("ANUAL")) {
		ResultSet resul = ps.executeQuery(sql);

		

			while (resul.next()) {

				logger.info(resul.getString("email"));
				


			}			
    	}

		return listausuarios;

	}
	public Usuario buscarpoid(String id ) throws AppException, SQLException {
		
		Usuario usuariodevuelve = null;
  	String consulta= "select * from parradomanuel.usuarios where id =?";
  
			Connection conexion= conector.getConnect();
	    	PreparedStatement ps = conexion.prepareStatement(consulta);
	    	ps.setString(1, id);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				Usuario u = new Usuario();

				u.setId(rs.getString("id"));

				u.setUsername(rs.getString("username"));

				u.setEmail(rs.getString("email"));

				u.setPlan_activo(PlanActivo.valueOf(rs.getString("plan_activo")));

				u.setDispositivo(rs.getString("dispositivo"));

				u.setPreferencias(this.getpreferenciaporid(id));
				
				usuariodevuelve=u;
			}
			
	    	
          
         
          conexion.close();

      return usuariodevuelve;

	}
	public void registrarnuevousuario(Usuario usuario) throws AppException, SQLException {
		String consulta= "insert into parradomanuel.usuarios(id,username,email,plan_activo,dispositivo) values(?,?,?,?,?)";
		PreparedStatement ps;
		if(this.buscarpoid(usuario.getId())==null) {
			Connection conexion= conector.getConnect();
			ps=conexion.prepareStatement(consulta);
						
			ps.setString(1,usuario.getId());			
			ps.setString(2, usuario.getUsername());
			ps.setString(3, usuario.getEmail());

			ps.setString(4, usuario.getPlan_activo().name());
			ps.setString(5, usuario.getDispositivo());
			ps.executeUpdate();

	    	
			logger.info("Usuario añadido " + usuario.getId());

			usuarios.add(usuario);


		}

		else {
			throw new AppException("ERROR: Ya existe este usuario");
		}
}
	public int calculanumerodeusuariosvip(PlanActivo plan_activo) throws SQLException {
		//LO HE INTENTADO DE TODAS MANERAS POSIBLES Y ME SALE ERROR DEL WHERE
		String consulta= "select count(*) as total from parradomanuel.usuarios where plan_activo = "+ "VIP";
		int partidascontadas=0;
    	Connection conexion;
			conexion = conector.getConnect();
			PreparedStatement ps;
			ps = conexion.prepareStatement(consulta);
			if(plan_activo.name().equals("VIP")) {
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			partidascontadas= rs.getInt("total");
			}
			// TODO Auto-generated catch block
			}
    	
		  	return partidascontadas;
	}
		
		
	

}
