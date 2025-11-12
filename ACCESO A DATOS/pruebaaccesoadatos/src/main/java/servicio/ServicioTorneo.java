package servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.TorneoException;
import modelo.Enfrentamiento;
import modelo.Equipo;
import repositorio.RepoEnfrentamiento;
import repositorio.RepoEquipo;

public class ServicioTorneo {
	private static final Logger logger = LogManager.getLogger(ServicioTorneo.class);

	private RepoEquipo repositorioequipo;
	private RepoEnfrentamiento repositorioenfrentamiento;

    public ServicioTorneo() {
        this.repositorioequipo = new RepoEquipo();
        this.repositorioenfrentamiento= new RepoEnfrentamiento();
    }
    
    public void agregarEquipo(Equipo equipo)  {
    	try {
			repositorioequipo.agregarEquipo(equipo);
		} catch (TorneoException e) {
			// TODO Auto-generated catch block
			logger.error("Error: Ya existe");;
		}
    }
    
    public Equipo getequipo (String id ) {
		return repositorioequipo.getequipo(id);
}
    public void agregalistaequipo(List<Equipo>listaequiposañadir)  {
    	
    	for (Equipo equipo : listaequiposañadir) {
			try {
				repositorioequipo.agregarEquipo(equipo);
			} catch (TorneoException e) {
				// TODO Auto-generated catch block
				logger.error("Error: Ya existe");
			}
		}
    	
    }
    public Enfrentamiento getenfrentamiento(int id) {
		return repositorioenfrentamiento.getenfrentamiento(id);
    	
    }
    
    public void agregalistaenfretameintos (List<Enfrentamiento> listaenfrentaimentosañadir) {
    	for (Enfrentamiento enfrentamiento : listaenfrentaimentosañadir) {
			try {
				repositorioenfrentamiento.agregarenfrentamiento(enfrentamiento);
			} catch (TorneoException e) {
				// TODO Auto-generated catch block
				logger.error("Error: Ya existe");
			}
		}    }

}
