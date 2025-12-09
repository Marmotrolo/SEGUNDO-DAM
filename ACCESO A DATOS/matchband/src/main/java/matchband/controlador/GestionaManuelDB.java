package matchband.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import matchband.config.MongoDBConexion;
import matchband.modelo.Anuncio;
import matchband.modelo.Genero;
import matchband.modelo.Musico;
import matchband.modelo.Perfil;
import matchband.repositorio.MusicoRepositorio;
import matchband.servicio.MusicoServicio;

public class GestionaManuelDB {
	private static final Logger logger = LogManager.getLogger(GestionaManuelDB.class);
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
//TODO Aqu� creamos los diferentes servicios a partir del objeto db
		MusicoRepositorio repo= new MusicoRepositorio(db);
		MusicoServicio servicio= new MusicoServicio(db);

		Perfil perfilNuevo = new Perfil();		
		perfilNuevo.setGenero(Genero.ROCK); //Si no lo seteo me da excepcion nullpointer
		List<Anuncio> anunciosIniciales = new ArrayList<>();
		
		Musico m1= new Musico(6,"Manuel Parrado Torres" , "manuelparradotorres@gmail.com", "03-11-2006", perfilNuevo, anunciosIniciales);
		Musico m2= new Musico(7,"Victoria Garcia Moreno" , "victoriagarciamoreno@gmail.com", "06-06-2007", perfilNuevo, anunciosIniciales);

		//Añadir nuevo musico
		//servicio.save(m2);
		
		 List<Musico> musicos= repo.read();
		 logger.info("------------------MUSICOS----------------------");

		 for (Musico musico : musicos) {
			 logger.info(musico); 
		}
		 //Borramos el musico con id 7
		repo.delete(7);
		List<Musico> musicosdeleteupdate= repo.read();

		logger.info("------------------MUSICOS (ID 7 BORRADO Y ACTUALIZO ID 3)----------------------");
		//Actualizo el musico con id 3
		Musico m3= servicio.getMusicoPorId(3) ;
		logger.info(m3);
		m3.setNombreCompleto("julian navas");
		List<Anuncio> anuncionsm3= m3.getAnuncios();
		for (Anuncio anuncio : anuncionsm3) {
			
		}
		servicio.update(m3);

		 for (Musico musico : musicosdeleteupdate) {
			 logger.info(musico); 
		}
	 logger.info("--------------------ORDENADOS DESCENDIENTEMENTE-----------------------");
	 List<Musico> musicosordenadosdescendentemente= servicio.sortiddescendente();
	 for (Musico musico : musicosordenadosdescendentemente) {
		logger.info(musico);
	}
		logger.info("--------------------ORDENADOS ALFABETICAMENTE-----------------------");
		List<Musico> musicosordenadosalfabeticamente = servicio.ordenaralfabeticamente();
		for (Musico musico : musicosordenadosalfabeticamente) {
			logger.info(musico);
		}
		logger.info("--------------------FILTRADOS POR GENERO-----------------------");
		List<Musico> musicosfiltradosporgenero= servicio.filtrarporgenero(Genero.ROCK);
		for (Musico musico : musicosfiltradosporgenero) {
			logger.info(musico);
		}
		logger.info("----------	----------FILTRADOS POR ID-----------------------");
		Musico musicosfiltradosporid= servicio.getMusicoPorId(5);

			logger.info(musicosfiltradosporid);
		}
	}


