package towergpt.repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;

public class Repositoriointeracciones implements IRepositoriointeracciones{
	private static final Logger logger = LogManager.getLogger(Repositoriointeracciones.class);

	
	
	private static Set <InteraccionAgente> interacciones;
	
	
	
	
	
	
	

	public Repositoriointeracciones() {
		super();
		this.interacciones = new HashSet<>() ;
	}
	
	

	public static Set<InteraccionAgente> getInteracciones() {
		return interacciones;
	}



	public void setInteracciones(Set<InteraccionAgente> interacciones) {
		this.interacciones = interacciones;
	}



	@Override
	public void agregarInteraccionARegistro(InteraccionAgente interaccion) {
interacciones.add(interaccion);		
	}

	@Override
	public InteraccionAgente obtenerInteraccionConMejorValoracion() {
		InteraccionAgente interaccionmejorvalorada=null;
		double valoracioninteraccion= 0;
	
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(valoracioninteraccion< interaccionAgente.getValoracion()) {
				valoracioninteraccion= interaccionAgente.getValoracion();
				interaccionmejorvalorada= interaccionAgente;
			}
		}
	
		return interaccionmejorvalorada;
	}

	@Override
	public List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentaje) {
	    List<InteraccionAgente> interaccionesFiltradas = new ArrayList<>();

	    for (InteraccionAgente interaccion : interacciones) {
	        if (interaccion.getPorcentajeAcierto() > porcentaje) {
	            interaccionesFiltradas.add(interaccion);
	        }
	    }

	    Collections.sort(interaccionesFiltradas);

	    return interaccionesFiltradas;
	}
	
	
	@Override
	public double obtenerTiempoMedioPorAgente(TipoAgente tipo) {
		double tiempomedioagente=0;
		
		if(tipo == TipoAgente.AI) {
			tiempomedioagente=obtenerTiempoMedioPorAgenteAI();
		}
		else if (tipo== TipoAgente.HUMANO) {
			tiempomedioagente=obtenerTiempoMedioPorAgenteHumano();
		}
		
		return tiempomedioagente;
	}
	
	public double obtenerTiempoMedioPorAgenteHumano() {
		int contador=0;
		double tiempomediohumano=0;
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(interaccionAgente.getTipoAgente() == TipoAgente.HUMANO) {
				tiempomediohumano= tiempomediohumano + interaccionAgente.getTiempoResolucion();
				contador++;
				
			}
			
		}
		
		return tiempomediohumano/contador;
	}	
	public double obtenerTiempoMedioPorAgenteAI() {
		int contador=0;
		double tiempomedioai=0;
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(interaccionAgente.getTipoAgente() == TipoAgente.AI) {
				tiempomedioai= tiempomedioai + interaccionAgente.getTiempoResolucion();
				contador++;
				
			}
			
		}
		
		return tiempomedioai/contador;		
	}

	@Override
	public double obtenerPorcentajeAciertoMedioPorAgente(TipoAgente tipo) {
		double porcentajemedioagente=0;
		
		if(tipo == TipoAgente.AI) {
			porcentajemedioagente=obtenerPorcentajeAciertoMedioPorAgenteAI();
		}
		else if (tipo== TipoAgente.HUMANO) {
			porcentajemedioagente=obtenerPorcentajeAciertoMedioPorAgenteHumano();
		}
		
		return porcentajemedioagente;	
	}

	public double obtenerPorcentajeAciertoMedioPorAgenteAI() {
		int contador=0;
		double porcentajeacierdomedioai=0;
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(interaccionAgente.getTipoAgente() == TipoAgente.AI) {
				porcentajeacierdomedioai= porcentajeacierdomedioai + interaccionAgente.getPorcentajeAcierto();
				contador++;
				
			}
			
		}
		
		return porcentajeacierdomedioai/contador;	
		
		
	}	
	
	public double obtenerPorcentajeAciertoMedioPorAgenteHumano() {
		int contador=0;
		double porcentajeacierdomediohumano=0;
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(interaccionAgente.getTipoAgente() == TipoAgente.AI) {
				porcentajeacierdomediohumano= porcentajeacierdomediohumano + interaccionAgente.getPorcentajeAcierto();
				contador++;
				
			}
			
		}
		
		return porcentajeacierdomediohumano/contador;		
	}
	@Override
	public void actualizaPorcentajeInteraccion(InteraccionAgente interaccion, double porcentajeNuevo) {
		InteraccionAgente interaccionagente= BuscaInteraccionPorId(interaccion.getId());
		if(interaccionagente !=null) {
			interaccionagente.setPorcentajeAcierto(porcentajeNuevo);
		}
	
	}

	@Override
	public void incrementaNumeroValoraciones(int id) {
		InteraccionAgente interaccionagente= BuscaInteraccionPorId(id);
		if(interaccionagente !=null) {
			
			double incrementauno = interaccionagente.getValoracion() + 1;
			interaccionagente.setPorcentajeAcierto(incrementauno );
		}
			
	}

	@Override
	public boolean eliminarInteraccion(int id) {
		InteraccionAgente interaccionagente= BuscaInteraccionPorId(id);
		boolean borrado=false;
		if(interaccionagente != null) {
			borrado=true;
			interacciones.remove(interaccionagente);
		}
		return borrado;
	}

	public InteraccionAgente BuscaInteraccionPorId (int id){
		InteraccionAgente interaccionencontrada = null;
	    boolean encontrado = false;
	    while (!encontrado) {
	        for (InteraccionAgente interaccion : interacciones) {
	            if (interaccion.getId() == id) {
	                interaccionencontrada = interaccion;
	                encontrado = true; 
	            }
	        }
	        if (!encontrado) {
	            logger.info("No se encontró iteracción");
	            encontrado = true; 
	        }
	    }

	    return interaccionencontrada;
	}
}
