package towergpt.servicio;
import java.util.*;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;

public interface IServicioEstadistica {

	    InteraccionAgente obtenerInteraccionConMejorValoracion(Set<InteraccionAgente> interacciones);
	    double calcularTiempoMedioPorTipo(TipoAgente tipo, Set<InteraccionAgente> interacciones);
	    double calcularPorcentajeAciertoMedioPorTipo(TipoAgente tipo, Set<InteraccionAgente> interacciones);
	    Map<TipoAgente, List<InteraccionAgente>> agruparInteraccionesPorTipo(Set<InteraccionAgente> interacciones, TipoAgente tipo);
	    List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentaje, Set<InteraccionAgente> interacciones);
		Set<InteraccionAgente> cargarRegistrosDesdeJSON(String ruta); 
	    void grabarFicheroCSV(String ruta, Set<InteraccionAgente> interacciones);
	    void grabarResumenEstadistica(String ruta, Set<InteraccionAgente> interacciones);

}
