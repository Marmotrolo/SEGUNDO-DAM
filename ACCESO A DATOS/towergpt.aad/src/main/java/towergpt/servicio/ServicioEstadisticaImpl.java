package towergpt.servicio;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;

public class ServicioEstadisticaImpl implements IServicioEstadistica  {
	
	
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
	public InteraccionAgente obtenerInteraccionConMejorValoracion(Set<InteraccionAgente> interacciones) {
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
	public double calcularTiempoMedioPorTipo(TipoAgente tipo, Set<InteraccionAgente> interacciones) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPorcentajeAciertoMedioPorTipo(TipoAgente tipo, Set<InteraccionAgente> interacciones) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentaje,
			Set<InteraccionAgente> interacciones) {
			List<InteraccionAgente> interaccionesagentemayorqueporcentajepedido = new ArrayList<InteraccionAgente> ();
			
			for (InteraccionAgente interaccionAgente : interacciones) {
				if(interaccionAgente.getPorcentajeAcierto()> porcentaje) {
					interaccionesagentemayorqueporcentajepedido.add(interaccionAgente);
				}
			}
			
		return interaccionesagentemayorqueporcentajepedido;
	}
	
	


	@Override
	public void grabarResumenEstadistica(String ruta, Set<InteraccionAgente> interacciones) {
		// TODO Auto-generated method stub
		
	}
}
