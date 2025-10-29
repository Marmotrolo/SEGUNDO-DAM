package towergpt.servicio;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;
import towergpt.repositorio.Repositoriointeracciones;

public class ServicioEstadisticaImpl implements IServicioEstadistica  {
	
	Repositoriointeracciones repo = new Repositoriointeracciones();
	
	@Override
	public Map<TipoAgente, List<InteraccionAgente>> agruparInteraccionesPorTipo(Set<InteraccionAgente> interacciones, TipoAgente tipo) {
		Map<TipoAgente , List<InteraccionAgente>> interaccionesregistradasportipo = new HashMap<TipoAgente, List<InteraccionAgente>> ();
		if(tipo == TipoAgente.AI) {
			interaccionesregistradasportipo= agruparInteraccionesPorTipoIA( interacciones);
		}
		else if( tipo== TipoAgente.HUMANO) {
			interaccionesregistradasportipo= agruparInteraccionesPorTipoHumano(interacciones);
		}
		
		
		
		return interaccionesregistradasportipo;
	}

	public Map<TipoAgente, List<InteraccionAgente>> agruparInteraccionesPorTipoHumano(
			Set<InteraccionAgente> interacciones) {
		Map<TipoAgente , List<InteraccionAgente>> interaccionesregistradasportipoHumano = new HashMap<TipoAgente, List<InteraccionAgente>> ();
		List<InteraccionAgente> interaccionesagenteHumano = new ArrayList<InteraccionAgente>();
		
		for (InteraccionAgente interaccionAgente : interacciones) {
			if(interaccionAgente.getTipoAgente() == TipoAgente.HUMANO) {
				interaccionesagenteHumano.add(interaccionAgente);
			}
			
		}
		interaccionesregistradasportipoHumano.put(TipoAgente.HUMANO,interaccionesagenteHumano);
		
		
		
		return interaccionesregistradasportipoHumano;
	}
	
	public Map<TipoAgente, List<InteraccionAgente>> agruparInteraccionesPorTipoIA(
			Set<InteraccionAgente> interacciones) {
			Map<TipoAgente , List<InteraccionAgente>> interaccionesregistradasportipoAI = new HashMap<TipoAgente, List<InteraccionAgente>> ();
			List<InteraccionAgente> interaccionesagenteAI = new ArrayList<InteraccionAgente>();
			
			for (InteraccionAgente interaccionAgente : interacciones) {
				if(interaccionAgente.getTipoAgente() == TipoAgente.AI) {
					interaccionesagenteAI.add(interaccionAgente);
				}
				
			}
			interaccionesregistradasportipoAI.put(TipoAgente.AI,interaccionesagenteAI);
			
			
			
			return interaccionesregistradasportipoAI;
	}

	@Override
	public double calcularTiempoMedioPorTipo(TipoAgente tipo) {
		return repo.obtenerTiempoMedioPorAgente(tipo);
	}

	@Override
	public double calcularPorcentajeAciertoMedioPorTipo(TipoAgente tipo) {
		return repo.obtenerPorcentajeAciertoMedioPorAgente(tipo);
	}



	@Override
	public List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentaje) {
		
			
		return repo.obtenerInteraccionesAciertoMayorQueOrdenadas(porcentaje);
	}
	




	@Override
	public void grabarResumenEstadistica(String ruta, Set<InteraccionAgente> interacciones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eliminarInteraccion(int id) {
		return repo.eliminarInteraccion(id);
	}

	@Override
	public void agregarInteraccionARegistro(InteraccionAgente interaccion) {
		repo.agregarInteraccionARegistro(interaccion);		
	}

	@Override
	public InteraccionAgente obtenerInteraccionConMejorValoracion() {
		return repo.obtenerInteraccionConMejorValoracion();
	}





	

	



}
