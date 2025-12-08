package matchband.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mongodb.client.MongoDatabase;

import matchband.modelo.Genero;
import matchband.modelo.Musico;
import matchband.repositorio.MusicoRepositorio;

public class MusicoServicio {

	private MusicoRepositorio repo;

	public MusicoServicio(MongoDatabase db) {
		super();
		this.repo = new MusicoRepositorio(db);
	}
	 public void save(Musico e) {
	       // Aqu� podr�as a�adir validaciones, reglas de negocio, etc.
	       repo.save(e);
	   }
	   // Lista todos los estudiantes
	   public List<Musico> read() {
	       return repo.read();
	   }
	   public void delete(int id) {
		    repo.delete(id);
	   }
	   public void update (Musico m) {
		   repo.update(m);
	   }
	   public Musico getMusicoPorId(int  id){
			return repo.getMusicoPorId(id);
			 }
	   public List<Musico> sortiddescendente(){
		   return repo.sortiddescendente();
	   }
	   
	   public List<Musico> ordenaralfabeticamente (){
		   List<Musico> musicos = repo.read();
		    Collections.sort(musicos); 
		    return musicos;
	   }
	   public List<Musico> filtrarporgenero(Genero genero){
		   List<Musico> musicos = repo.read();
		   List<Musico> musicosfiltradosporgenero = new ArrayList<>();
		   for (Musico musico : musicos) {
			if (musico.getPerfil().getGenero().equals(genero)) {
				musicosfiltradosporgenero.add(musico);
			}
			
		}
		   return musicosfiltradosporgenero;
	   }
	
	 
	//TODO Agregar resto de operaciones del CRUD
	   public MusicoRepositorio getRepo() {
		   return repo;
	   }
	
}
