package servicio;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import modelo.AppException;
import modelo.PlanActivo;
import modelo.Usuario;
import repositorio.UsuarioRepositorio;

public class UsuarioServicio {
	private static final Logger logger = LogManager.getLogger(UsuarioServicio.class);

	  private final UsuarioRepositorio repo;
	  
	  
	  public UsuarioServicio() throws AppException, SQLException {
		super();
		this.repo = new UsuarioRepositorio();
	  }
	  
	  public List<Usuario> obtenerusuarios(){
		  List<Usuario> listausuarios= null;
		  try {
			listausuarios=repo.cargarusuarios();
		  } catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  return listausuarios;
	  }
	  
	  public Usuario usuarioporid(String id ) {
		  Usuario usuario= null;
		  
		  try {
			usuario= repo.buscarpoid(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return usuario;
		  
	  }
	  public List<Usuario> obtenerusuariosporplanactivo(PlanActivo plan_activo){
	  List<Usuario> listausuarios= null;
	  try {
		listausuarios=repo.cargarusuariosporplanactivo(plan_activo);
	  } catch (AppException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  return listausuarios;
  }
	  public void insertarusuario(Usuario usuario) {
		  
		  try {
			repo.registrarnuevousuario(usuario);
		  } catch (AppException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	  }
	  
	  public int numerodeusuariosvip(PlanActivo plan_activo) {
		  int usuariosvip= 0;
		  
		  try {
			usuariosvip= repo.calculanumerodeusuariosvip(plan_activo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return usuariosvip;
		  
		  
	  }
  
}
