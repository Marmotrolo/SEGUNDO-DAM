package examenMongodb.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DeleteManyModel;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import examenMongodb.modelo.AppException;
import examenMongodb.modelo.Evento;
import examenMongodb.modelo.PlanActivo;
import examenMongodb.modelo.Preferencias;
import examenMongodb.modelo.Usuario;



public class RepoUsuarios {
	private static final Logger logger = LogManager.getLogger(RepoUsuarios.class);

	 private static final String NOMBRE_COLECCION = "usuarios";
	   private final MongoCollection<Document> coleccion;
	   

		public RepoUsuarios(MongoDatabase db) {
	        this.coleccion = db.getCollection(NOMBRE_COLECCION);
	    }
		private Usuario fromUsuarioDocument2Java(Document doc) {
			Usuario u = new Usuario();
	 		u.setId(doc.getString("id"));
	 		u.setUsername(doc.getString("username"));
	 		u.setEmail(doc.getString("email"));
	 		u.setDispositivo(doc.getString("dispositivo"));
	        u.setPlan_activo(PlanActivo.valueOf(doc.getString("plan_activo")));
	 		
	 		Document docPreferencias= doc.get("preferencias", Document.class);
	 		Preferencias p= new Preferencias();
	 		p.setTema_oscuro(docPreferencias.getBoolean("tema_oscuro"));
	 		p.setIdioma(docPreferencias.getString("idioma"));
	 		p.setLimite_datos_moviles(docPreferencias.getBoolean("limite_datos_moviles"));
	 		p.setNotificaciones_push(docPreferencias.getBoolean("notificaciones_push"));

	 		
	 		List<Document> logsDocs = doc.getList("eventosLogs", Document.class);
		 	        List<Evento> logslista= new ArrayList<>();
		 	        for (Document lognDoc : logsDocs) {
		 	        	Evento e = new Evento();
		 	            e.setId_evento(lognDoc.getString("id_evento"));
		 	            e.setTag(lognDoc.getString("tag"));
		 	            e.setMensaje(lognDoc.getString("mensaje"));
		 	            e.setTimestamp(lognDoc.getString("timestamp"));
		 	            
		 	            
		 	           
		 	           logslista.add(e);
		 	        }
		 	        u.setLogs_eventos(logslista);
	 		u.setPreferencias(p);
	 		return u;
		}
		public Document usuadoc(Usuario u) {
			Document preferenciasDoc = new Document();
			if(u.getPreferencias() != null) {
				preferenciasDoc
            .append("tema_oscuro", u.getPreferencias().isTema_oscuro())
            .append("idioma", u.getPreferencias().getIdioma())
            .append("notificaciones_push", u.getPreferencias().isNotificaciones_push())
            .append("limite_datos_moviles", u.getPreferencias().isLimite_datos_moviles());
			
			}
		
		List<Document> eventosDocs = new ArrayList<>();
	    if( u.getLogs_eventos() !=null) {
	    for (Evento e :u.getLogs_eventos()) {
	        Document logdoc = new Document()
	                .append("id_evento", e.getId_evento()) 
	                .append("tag", e.getTag())
	                .append("mensaje", e.getMensaje())
	                .append("timestamp", e.getTimestamp());
	        
	        eventosDocs.add(logdoc);
	    }
}
	    Document usuariodoc = new Document("id", u.getId())
	            .append("username", u.getUsername())
	            .append("email", u.getEmail())
	            .append("plan_activo", u.getPlan_activo().name())			         
	            .append("dispositivo", u.getDispositivo()) 
	            .append("preferencias", preferenciasDoc)
	            .append("eventosLogs", eventosDocs); 
		return usuariodoc;

		}
public void save (Usuario u) throws AppException {
		 	
	 	    InsertOneResult resultado= coleccion.insertOne(usuadoc(u));
	 	    if(resultado.equals(0)) {
	 	    	throw new AppException("No se ha podido insertar el usuario");
	 	    }
	 	    logger.info("Se ha insertado el usuario" + resultado);
	 	}



public List<Usuario> read(){
		List<Usuario> listausuarios= new ArrayList<>();
		Document filtro= new Document ("plan_activo",-1).append("email", 1);
		FindIterable<Document> documentos= coleccion.find().sort(filtro);
		for (Document document : documentos) {
			Usuario u= fromUsuarioDocument2Java(document);
			listausuarios.add(u);
	}
		return listausuarios;
		
}
public Usuario getusuporid(String  id){		
	Usuario usuariobuscadoporid= null;
		Document encuentrausuario= new Document ("id", id);
		Document documento= coleccion.find(encuentrausuario).first();
		usuariobuscadoporid= fromUsuarioDocument2Java(documento);
		return usuariobuscadoporid;
		
}
public long actualizaESaESP () {
	
    Document filtro = new Document();
    Document prefenciaaactuazliar= new Document ("preferencias.idioma", "ESP");
	Document actualizacion= new Document("$set", prefenciaaactuazliar);
    UpdateResult resultado = coleccion.updateMany(filtro, actualizacion);
    
    return resultado.getModifiedCount();

}

public long eliminaregistroplanactivoanual() {
	
	Document filtroplanactivo= new Document ("plan_activo", "ANUAL");
	
	DeleteResult resultado= coleccion.deleteMany( filtroplanactivo );
	

	return resultado.getDeletedCount();
	
}
public List<Usuario> recupera3primerosusuarios() {
	List<Usuario> tresusuarios= new ArrayList<>();
	
	Document filtroplanactivomensual= new Document ("plan_activo", "MENSUAL").append("dispositivo", "android14");
	while(tresusuarios.size()<3) {
	for (Document documento : coleccion.find(filtroplanactivomensual).sort(new Document ("email", 1))) { 
        Usuario usuario = fromUsuarioDocument2Java(documento);
        tresusuarios.add(usuario);
    }
	}
	return tresusuarios;
			
}
 public long actualizalosplanactivovip () {
	 Document filtro = new Document("plan_activo", "VIP");
	    Document prefenciaaactuazliar= new Document ("preferencias.limite_datos_moviles", true);
		Document actualizacion= new Document("$set", prefenciaaactuazliar);
	    UpdateResult resultado = coleccion.updateMany(filtro, actualizacion);
	    
	    return resultado.getModifiedCount();	 
 }

 public long añadeventoporid () {
		
	    Document filtro = new Document("id", "usr008");	
	 
	    Document nuevoevento = new Document("id_evento", "ev_121")
	                                .append("tag", "GPS")
	                                .append("mensaje", "Señal GPS adquirida")
	                                .append("timestamp", "2024-02-12T08:21:00Z");
	 	
	 
	    Document actualizacion = new Document("$push", 
	        new Document("eventosLogs", nuevoevento)
	    );
	    
	
	    UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
		
	    return resultado.getModifiedCount();
	}

		}