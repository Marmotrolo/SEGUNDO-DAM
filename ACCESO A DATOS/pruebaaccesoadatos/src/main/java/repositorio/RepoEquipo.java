package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.TorneoException;
import modelo.Equipo;

public class RepoEquipo {

	
private static final Logger logger = LogManager.getLogger(RepoEquipo.class);
	
	private List<Equipo> listaEquipos;
	
	
	
	public RepoEquipo() {
		super();
		this.listaEquipos = new ArrayList<>();
	}


	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}


	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	
	public Equipo getequipo (String id ) {
		int i =0;
		boolean	encontrado=false;
		Equipo equipo= null;
		while(!encontrado && i< listaEquipos.size()) {
			
			if (listaEquipos.get(i).getId().equals(id)){
				encontrado=true;
				equipo= listaEquipos.get(i);
			}
			i++;
		}
		return equipo;
		
		
	}
	
	public void agregarEquipo(Equipo equipo) throws TorneoException {
		
		int i =0;
		boolean	encontrado=false;
		
		while(!encontrado && i< listaEquipos.size()) {
		
				if (listaEquipos.get(i).equals(equipo.getId())){
					encontrado=true;
				throw new TorneoException("Error: Ya existe");
					}
				i++;
			}
		
			
		if(encontrado=true) {
			listaEquipos.add(equipo);

			}
		}
	
	
	}


