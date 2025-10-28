package towergpt.repositorio;


import java.util.List;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;

public interface IRepositoriointeracciones {
    void agregarInteraccionARegistro(InteraccionAgente interaccion);

    InteraccionAgente obtenerInteraccionConMejorValoracion();
    List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(double porcentajeAcierto);
    double obtenerTiempoMedioPorAgente(TipoAgente tipo);
    double obtenerPorcentajeAciertoMedioPorAgente(TipoAgente tipo);

    void actualizaPorcentajeInteraccion(InteraccionAgente interaccion, double porcentajeNuevo);
    void incrementaNumeroValoraciones(int id);

    boolean eliminarInteraccion(int id);
}
