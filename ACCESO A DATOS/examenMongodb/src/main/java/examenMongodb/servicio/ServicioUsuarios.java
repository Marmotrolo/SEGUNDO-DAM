package examenMongodb.servicio;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import examenMongodb.modelo.AppException;
import examenMongodb.modelo.Usuario;
import examenMongodb.repositorio.RepoUsuarios;

public class ServicioUsuarios {

		private RepoUsuarios repo;

		public ServicioUsuarios(MongoDatabase db) {
			super();
			this.repo = new RepoUsuarios(db);
		}
		
		 public void save(Usuario u) {
		       try {
				repo.save(u);
			   } catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
		   }

		 public List<Usuario> read() {
		       return repo.read();
		   }
		 
		 public Usuario getusuporid(String id) {
			 return repo.getusuporid(id);
		 }
		 
		 public long actualizaESaESP() {
			 return repo.actualizaESaESP();
		 }
		 public long eliminaresgistroplanactivo() {
			 return repo.eliminaregistroplanactivoanual();
		 }
		 
		 public List<Usuario> recupera3primerosusuarios(){
			 return repo.recupera3primerosusuarios();
		 }
		 
		
}
