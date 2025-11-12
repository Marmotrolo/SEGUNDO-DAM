package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.TorneoException;
import modelo.Enfrentamiento;
import modelo.Equipo;

public class RepoEnfrentamiento {
private static final Logger logger = LogManager.getLogger(RepoEnfrentamiento.class);
	
	private List<Enfrentamiento> listaenfretamientos;
	
	
	
	public RepoEnfrentamiento() {
		super();
		this.listaenfretamientos = new ArrayList<>();
	}


	public List<Enfrentamiento> getListaEquipos() {
		return listaenfretamientos;
	}


	public void setListaEquipos(List<Enfrentamiento> listaEquipos) {
		this.listaenfretamientos = listaenfretamientos;
	}

	
	public Enfrentamiento getenfrentamiento (int id ) {
		int i =0;
		boolean	encontrado=false;
		Enfrentamiento enfrentamiento= null;
		while(!encontrado && i< listaenfretamientos.size()) {
			
			if (listaenfretamientos.get(i).getId() == id){
				encontrado=true;
				enfrentamiento= listaenfretamientos.get(i);
			}
			i++;
		}
		return enfrentamiento;
		
		
	}
	
	public void agregarenfrentamiento(Enfrentamiento enfrentamiento) throws TorneoException {
		
		int i =0;
		boolean	encontrado=false;
		
		while(!encontrado && i< listaenfretamientos.size()) {
		
				if (listaenfretamientos.get(i).getId()== enfrentamiento.getId()){
					encontrado=true;
				throw new TorneoException("Error: Ya existe");
					}
				i++;
			}
		
			
		if(encontrado=true) {
			listaenfretamientos.add(enfrentamiento);

			}
		}
}
