package hoteles.gestiona;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import hoteles.config.MongoDBConexion;
import hoteles.modelo.Hotel;
import hoteles.repositorio.HotelesRepositorio;



public class GestionaHoteles {
	private static final Logger logger = LogManager.getLogger(GestionaHoteles.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
//TODO Aquï¿½ creamos los diferentes servicios a partir del objeto db
		HotelesRepositorio repo= new HotelesRepositorio(db);
		
		List<Hotel> hoteles= repo.read();
		for (Hotel hotel : hoteles) {
			logger.info(hotel);
		}
		
		List<Hotel> hotelesmadrid= repo.gethotelesenmadrid5estrellasoqueadmitanmascotas();
		for (Hotel hotel : hotelesmadrid) {
			logger.info(hotel);
		}
		int hotelessuitejunior= repo.gethotelessuitejunior();
		{
			logger.info(hotelessuitejunior);
		}
		
		long modificado= repo.añadehabitacionporid("h127");
		logger.info(modificado);
		
		long modificadocodigpostal= repo.actualizagranviaa28013();
		logger.info(modificadocodigpostal);
		
		long modificadoprecio= repo.actualizaprecioh101();
		logger.info(modificadoprecio);
		
		long borrahabitacioneshotel= repo.eliminaarrayhabitacionesmayora300granhotelcentral();
		logger.info(borrahabitacioneshotel);
}
	
}