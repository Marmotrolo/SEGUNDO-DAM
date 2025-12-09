package hoteles.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import hoteles.modelo.Coordenadas;
import hoteles.modelo.Habitacion;
import hoteles.modelo.Hotel;
import hoteles.modelo.Tipo;
import hoteles.modelo.Ubicacion;
import matchband.modelo.Musico;


public class HotelesRepositorio {
	 private static final String NOMBRE_COLECCION = "hoteles";
	   private final MongoCollection<Document> coleccion;
	   

		public HotelesRepositorio(MongoDatabase db) {
	        this.coleccion = db.getCollection(NOMBRE_COLECCION);
	    }
		
		private Hotel fromHotelDocument2Java(Document doc) {
			Hotel h = new Hotel();
	 		h.setIdHotel(doc.getString("idHotel"));
	 		h.setNombre(doc.getString("nombreCompleto"));
	 		h.setEstrellas(doc.getInteger("estrellas",0));
	 		h.setAdmiteMascotas(doc.getBoolean("admiteMascotas",false));
	 		h.setFechaApertura(doc.getString("fechaApertura"));
	 		
	 		Document docUbicacion= doc.get("ubicacion", Document.class);
	 		Ubicacion u= new Ubicacion();
	 		u.setCalle(docUbicacion.getString("calle"));
	 		u.setNumero(docUbicacion.getInteger("numero",0));
	 		u.setCodigoPostal(docUbicacion.getInteger("codigoPostal", 0));
	 		
	 		Document docCoordenadas= doc.get("coordenadas", Document.class);
	 		Coordenadas c= new Coordenadas();
	 		c.setLat(docUbicacion.getInteger("lat",0));
	 		c.setLon(docUbicacion.getInteger("lon",0));
	 		u.setCoordenadas(c);
	 		
	 		//Crear lista de documentos habitacion
	 		List<Document> habitacionesDocs = doc.getList("habitaciones", Document.class);
	 	   //Crear lista de anuncios que sea añade al Musico
	 	        List<Habitacion> habitacioneslista= new ArrayList<>();
	 	        // Iteramos sobre cada Documento dentro de la lista
	 	        for (Document habitacionDoc : habitacionesDocs) {
	 	        	Habitacion a = new Habitacion();
	 	            a.setTipo(Tipo.valueOf(habitacionDoc.getString("tipo")));
	 	            a.setCapacidad(habitacionDoc.getInteger("capacidad",0));
	 	            a.setDisponible(habitacionDoc.getBoolean("disponible"));
	 	            // Usamos Double para el precio decimal
	 	            Number precio= habitacionDoc.get("precio", Number.class);
	 	            a.setPrecio(precio.doubleValue()); 
	 	            
	 	           
	 	           habitacioneslista.add(a);
	 	        }
	 	        h.setHabitaciones(habitacioneslista);
	 		
	 		h.setUbicacion(u);
	 		
	 		
			return h;
	 		

		}
		public Document musicoadoc(Hotel h) {
			Document coordenadasDoc = new Document();
			if(h.getUbicacion().getCoordenadas() != null) {
				coordenadasDoc
            .append("lat", h.getUbicacion().getCoordenadas().getLat())
            .append("lon", h.getUbicacion().getCoordenadas().getLon());
          
            
			}
	 		Document ubicacionDoc = new Document();
				if(h.getUbicacion() != null) {
					ubicacionDoc
	            .append("calle", h.getUbicacion().getCalle())
	            .append("numero", h.getUbicacion().getNumero()) 
	            .append("experiencia", h.getUbicacion().getCodigoPostal())
	            .append("genero", h.getUbicacion().getCoordenadas());
	            
				}
				
		}
		
}