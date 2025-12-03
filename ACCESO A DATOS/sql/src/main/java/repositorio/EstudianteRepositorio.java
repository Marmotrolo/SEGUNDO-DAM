package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import modelo.Direccion;
import modelo.Estudiante;
import modelo.Puntuacion;

public class EstudianteRepositorio {
	   private static final String NOMBRE_COLECCION = "estudiantes";
	  private final MongoCollection<Document> coleccion;
	  private List<Estudiante> estudiantes;

	   public EstudianteRepositorio(MongoDatabase db) {
	       this.coleccion = db.getCollection(NOMBRE_COLECCION);
	       this.estudiantes= this.read();
	   }

	public void save(Estudiante e) {
	       Document docAdress= new Document("adress" , e.getAdress())
	    		   .append("city", e.getAdress().getCity())
	    		   .append("zip", e.getAdress().getZip())
	    		   .append("street", e.getAdress().getStreet())
	    		   .append("number", e.getAdress().getNumber());
	       List<Document> ListdocScores= new ArrayList<>();
	       for (Puntuacion puntuacion : e.getScores()) {
	    	  Document docScores= new Document("score", puntuacion.getPuntuacion());
			ListdocScores.add(docScores);
		}
	       
	       Document doc = new Document("id", e.getId())
	               .append("name", e.getName())
	               .append("notaMedia", e.getNotaMedia())
	               .append("aficiones", e.getCursos())
	               .append("scores", e.getScores())
	               .append("address", docAdress);
	       coleccion.insertOne(doc);

	       
		}
	
	
		public List<Estudiante> read() {
			List<Estudiante> estudiantes = new ArrayList<>();
			FindIterable<Document> documentos = coleccion.find();
			for (Document doc : documentos) {
				
				//direcciones 
				
				Estudiante e = new Estudiante();
				
				Document addressdoc= (Document) doc.get("address");
				if(addressdoc !=null) {
					Direccion address= new Direccion(addressdoc.getString("city"), addressdoc.getInteger("zip"), addressdoc.getString("street"), addressdoc.getInteger("number"));
					e.setAdress(address);
				}
				
				//puntuaciones
				
				List<Document> listadocScores= (List<Document>) doc.get("scores");
				
				List<Puntuacion> listapuntuaciones= new ArrayList<Puntuacion>();
				
				for (Document documentitero : listadocScores) {
					if(documentitero!= null) {
						Puntuacion puntuacion= new Puntuacion (documentitero.getDouble("score"), documentitero.getString("type"));
						listapuntuaciones.add(puntuacion);
						e.setScores(listapuntuaciones);
					}
					
				}
				
				
				e.setId(doc.getInteger("id", 0));
				e.setName(doc.getString("name"));
				e.setNotaMedia(doc.getDouble("notaMedia"));
				List<String> aficiones = doc.getList("aficiones", String.class);
				e.setCursos(aficiones != null ? aficiones : new ArrayList<>());
				estudiantes.add(e);
			}
			return estudiantes;
		}}
