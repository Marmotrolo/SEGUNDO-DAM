package controlador;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Usuario;
import repositorio.UsuarioRepositorio;
import servicio.UsuarioServicio;


public class GestionaUsuarios {
	private static final Logger logger = LogManager.getLogger(GestionaUsuarios.class);
public static void main(String[] args) throws AppException, SQLException {
	UsuarioServicio servusuario= new UsuarioServicio();

	Usuario usuario1= new Usuario();
	
	usuario1.setPlan_activo(PlanActivo.ANUAL);
	usuario1.setId("asfsfd");
	usuario1.setUsername("adsfahga");
	usuario1.setDispositivo("adhadt");
	usuario1.setEmail("adthdfasdf");

	servusuario.insertarusuario(usuario1);
	
	List<Usuario> listausuarios= servusuario.obtenerusuarios();
	
	
	for (Usuario usuario : listausuarios) {
		logger.info(usuario);
	}
	
	
	logger.info(servusuario.usuarioporid("usr002"))
	;
	
List<Usuario> listausuariosplanactivo= servusuario.obtenerusuariosporplanactivo(PlanActivo.ANUAL);
	
	
	for (Usuario usuario : listausuarios) {
		logger.info(usuario);
	}
	logger.info(servusuario.numerodeusuariosvip(PlanActivo.VIP));
}
}
