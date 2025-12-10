package examenMongodb.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import examenMongodb.config.MongoDBConexion;
import examenMongodb.modelo.AppException;
import examenMongodb.modelo.Evento;
import examenMongodb.modelo.PlanActivo;
import examenMongodb.modelo.Preferencias;
import examenMongodb.modelo.Usuario;
import examenMongodb.repositorio.RepoUsuarios;
import examenMongodb.servicio.ServicioUsuarios;
import jdk.internal.net.http.common.Log;


public class GestionaParrado {
	
		private static final Logger logger = LogManager.getLogger(GestionaParrado.class);
		public static void main(String[] args) {
			MongoDBConexion conexion = new MongoDBConexion();
			MongoDatabase db= conexion.getDb();	
			
			
			Usuario usuario1= new Usuario();
			
			usuario1.setPlan_activo(PlanActivo.ANUAL);
			List<Evento> eventos = new ArrayList<>();
			Preferencias preferencias= new Preferencias();
			usuario1.setLogs_eventos(eventos);
			usuario1.setPreferencias(preferencias);
			RepoUsuarios repo= new RepoUsuarios(db);
			ServicioUsuarios serv= new ServicioUsuarios(db);

			/*try {
			 
				repo.save(usuario1);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Usuario> usuarios= repo.read();
			
			for (Usuario usuario : usuarios) {
				logger.info(usuario);
			}
			
			
			logger.info(serv.getusuporid("usr002"));
			
			logger.info("Cambiado: "+ serv.actualizaESaESP());
			
			logger.info( "Elimina: " + serv.eliminaresgistroplanactivo());
			
			List<Usuario> tresusuarios= serv.recupera3primerosusuarios();
			for (Usuario usuario : tresusuarios) {
				logger.info(usuario);
			}*/
				
			logger.info(repo.actualizalosplanactivovip());
			//no me da tiempo a terminarlo y ponerlo en el servicio
			
		}
}
		
		

