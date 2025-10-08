package ejerciciorepaso2.repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ejerciciorepaso2.modelo.Conversacion;
import ejerciciorepaso2.modelo.TipoAgente;

public class RepositorioConversaciones implements IRepositorioConversaciones {

	Set <Conversacion> conversaciones = new  HashSet <>() ;
	
	@Override
	public boolean contieneConversacion(Conversacion conversacion) {
	return conversaciones.contains(conversacion);
		
	}
	

	@Override
	public void eliminaconversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException {
		Conversacion conversacionbuscado = this.getConversacion(fecha, tipo);
		if(conversacionbuscado == null)
		{
			throw new ConversacionException("No existe brother");
		}
		this.conversaciones.remove(conversacionbuscado);
	}
	

	@Override
	public void agregaconversacion (String pregunta, String respuesta, TipoAgente tipo) {
		Conversacion nuevaconversacion = new Conversacion(pregunta,respuesta,tipo);
		conversaciones.add(nuevaconversacion);
		
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException{
			boolean encontrado = false;
			Conversacion conversacionbuscada = null;
			Iterator<Conversacion> it =conversaciones.iterator();
			 
			while (!encontrado && it.hasNext()) {
				Conversacion conversacionitero= it.next();
				if(conversacionitero.getFechaConversacion().equals(fecha) && conversacionitero.getTipo().equals(tipo) && conversacionitero.getPregunta().equals(pregunta))
				{
					encontrado = true;
					conversacionbuscada = conversacionitero;
				}
				else {
					throw new ConversacionException("No existe brother");

				}
			}
			
			return conversacionbuscada;
			
		}
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException {
		boolean encontrado = false;
		Conversacion conversacionbuscada = null;
		Iterator<Conversacion> it =conversaciones.iterator();
		 
		while (!encontrado && it.hasNext()) {
			Conversacion conversacionitero= it.next();
			if(conversacionitero.getFechaConversacion().equals(fecha) && conversacionitero.getTipo().equals(tipo) )
			{
				encontrado = true;
				conversacionbuscada = conversacionitero;
			}else {
				throw new ConversacionException("No existe brother");

			}
		}
		
		return conversacionbuscada;
		
	}
		
			

	@Override
	public void incrementanumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		Conversacion conversacionencontrada= this.getConversacion(fecha, tipo, pregunta);
		conversacionencontrada.setNumvaloracionespositivas(conversacionencontrada.getNumvaloracionespositivas()+1);
		}
	

}
