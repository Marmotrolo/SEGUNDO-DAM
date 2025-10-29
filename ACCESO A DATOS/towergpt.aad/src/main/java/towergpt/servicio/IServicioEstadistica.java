package towergpt.servicio;
import java.util.*;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;

public interface IServicioEstadistica {

	    double calcularPorcentajeAciertoMedioPorTipo(TipoAgente tipo);
	    Map<TipoAgente, List<InteraccionAgente>> agruparInteraccionesPorTipo(Set<InteraccionAgente> interacciones, TipoAgente tipo);
	    void grabarResumenEstadistica(String ruta, Set<InteraccionAgente> interacciones);
	    boolean eliminarInteraccion(int id);
	    void agregarInteraccionARegistro(InteraccionAgente interaccion);
	    InteraccionAgente obtenerInteraccionConMejorValoracion();
	    List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentajeAcierto);
		double calcularTiempoMedioPorTipo(TipoAgente tipo);


}
