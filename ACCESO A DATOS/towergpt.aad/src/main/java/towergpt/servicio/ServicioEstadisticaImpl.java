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
	
	public Set<InteraccionAgente> cargarRegistrosDesdeJSON(String ruta) {
	    Set<InteraccionAgente> interacciones = new HashSet<>();
	    Gson gson = new Gson();

	    try (FileReader reader = new FileReader(new String (ruta))) {
	        InteraccionAgente[] array = gson.fromJson(reader, InteraccionAgente[].class);
	        interacciones = new HashSet<>(Arrays.asList(array));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    return interacciones;
	}

	@Override
	public void grabarFicheroCSV(String ruta, Set<InteraccionAgente> interacciones) {
		 interacciones = clase_repo.getInteracciones();
			PrintWriter out = null;
		    File ruta_real = new File(ruta);

		    try {
		        FileWriter ficheroSalida = new FileWriter(ruta_real);
		        out = new PrintWriter(ficheroSalida);

		        out.println("Id,TipoAgente,Peticion,Respuesta,Valoracion,Porcentaje_Acierto");

		        for (InteraccionAgente a : interacciones) {
		        	out.printf(Locale.US, "%d,%s,%s,%s,%f,%d%n",
		        		    a.getId(),
		        		    a.getTipoAgente(),
		        		    a.getPeticion(),
		        		    a.getRespuesta(),
		        		    a.getValoracion(),
		        		    a.getPorcentaje_Acierto()
		        		);
		        }

		    } catch (IOException e) {
		        System.out.println("IOException");
		    } finally {
		        if (out != null)
		            out.close();
		    }
		}



	@Override
	public void grabarResumenEstadistica(String ruta, Set<InteraccionAgente> interacciones) {
		// TODO Auto-generated method stub
		
	}
}
