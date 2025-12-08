package mongodb.controlador;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import config.MongoDBConexion;
import modelo.Estudiante;
import servicio.EstudianteService;

public class GestionaManuelDB {
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
//TODO Aqu� creamos los diferentes servicios a partir del objeto db	
		
		
		
	 EstudianteService servicio= new EstudianteService(db);
	 //Estudiante estu1= new Estudiante(16, "felipe", 8.6, ["pene", "negros", "de mierda"], "negros", null);
	 
	 servicio.save(estu1);
	 List<Estudiante> estudiantes = servicio.read();
	 
	 for (Estudiante estudiante : estudiantes) {
		 System.out.println(estudiante);
		
	}
	 
	 
	}
}
