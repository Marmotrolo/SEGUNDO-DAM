package servicio;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import modelo.Estudiante;
import repositorio.MusicoRepositorio;

public class EstudianteService {
	  private final MusicoRepositorio repo;

	   // El servicio recibe MongoDatabase y construye el repositorio
	   public EstudianteService(MongoDatabase db) {
	       this.repo = new MusicoRepositorio(db);
	   }
	   // Guarda un estudiante en la base de datos
	   public void save(Estudiante e) {
	       // Aqu� podr�as a�adir validaciones, reglas de negocio, etc.
	       repo.save(e);
	   }
	   // Lista todos los estudiantes
	   public List<Estudiante> read() {
	       return repo.read();
	   }
	//TODO Agregar resto de operaciones del CRUD
	   public MusicoRepositorio getRepo() {
		   return repo;
	   }
	   
	   
	   
	}
