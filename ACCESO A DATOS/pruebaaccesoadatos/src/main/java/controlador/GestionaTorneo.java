package controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.TorneoException;
import modelo.Enfrentamiento;
import modelo.Equipo;
import servicio.ServicioTorneo;
import util.Generarjsontorneo;
import util.XMLDomTorneo;


public class GestionaTorneo {
	private static final Logger logger= LogManager.getLogger(GestionaTorneo.class);
public static void main(String[] args) {
	XMLDomTorneo xmldomtorneo = new XMLDomTorneo();
	ServicioTorneo serviciotorneo= new ServicioTorneo();
	Generarjsontorneo generarjson= new Generarjsontorneo();
	List<Equipo> listequipos;
	List<Enfrentamiento> listaenfrentamientos;
	try {
		
		listequipos = xmldomtorneo.leerEquiposDesdeXML("torneoGamer.xml");
		listaenfrentamientos=xmldomtorneo.leerEnfrentamientosDesdeXML("torneoGamer.xml");
		serviciotorneo.agregalistaenfretameintos(listaenfrentamientos);
		serviciotorneo.agregalistaequipo(listequipos);
		generarjson.generaJSONnoenventa(listaenfrentamientos);
		logger.info(listequipos);
		logger.info(listaenfrentamientos);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*List<Equipo> listaquipoagrgar= new ArrayList<Equipo>();
	Equipo equipo1 = new Equipo("equipo1", "g1", 3, "si");
	Equipo equipo2 = new Equipo("equipo2", "g1", 4, "si");
	Equipo equipo3 = new Equipo("equipo3", "g2", 8, "si");*/
	
	/*listaquipoagrgar.add(equipo1);
	listaquipoagrgar.add(equipo2);
	listaquipoagrgar.add(equipo3);*/


}
}
