package towergpt.main;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towergpt.modelo.InteraccionAgente;
import towergpt.modelo.TipoAgente;
import towergpt.repositorio.Repositoriointeracciones;
import towergpt.servicio.ServicioEstadisticaImpl;
import towergpt.utiles.UtilesInteraccionAgente;

public class ControladorTowerGPT {

    private static final Logger logger = LogManager.getLogger(ControladorTowerGPT.class);

    public static void main(String[] args) {

        String rutaCsv = "src/main/resources/towerGPT.csv";
        String rutaJson = "src/main/resources/tower.json";
        String rutaTxt = "src/main/resources/resumenEstadistica.txt";

        logger.info("=== INICIO DEL PROGRAMA TowerGPT ===");

        ServicioEstadisticaImpl servicio = new ServicioEstadisticaImpl();
        UtilesInteraccionAgente util = new UtilesInteraccionAgente();
        Repositoriointeracciones repo = new Repositoriointeracciones();

        Set<InteraccionAgente> interacciones = new HashSet<>();

        InteraccionAgente i1 = new InteraccionAgente( TipoAgente.AI, "ola", "adios", 4.5, 98.0, 1.2);
        InteraccionAgente i2 = new InteraccionAgente( TipoAgente.HUMANO, "2+2", "4", 5.0, 100.0, 0.8);
        InteraccionAgente i3 = new InteraccionAgente( TipoAgente.AI, "Soraya apruebame", "No", 4.7, 95.0, 2.1);
        InteraccionAgente i4 = new InteraccionAgente( TipoAgente.HUMANO, "Tocktock", "Quien es?", 3.8, 90.0, 0.5);

        interacciones.add(i1);
        interacciones.add(i2);
        interacciones.add(i3);
        interacciones.add(i4);

        for (InteraccionAgente interaccionagente : interacciones) {
            repo.agregarInteraccionARegistro(interaccionagente);
        }

        logger.info("Interacciones registradas:", interacciones.size());

        double tiempoMedioAI = servicio.calcularTiempoMedioPorTipo(TipoAgente.AI);
        double tiempoMedioHumano = servicio.calcularTiempoMedioPorTipo(TipoAgente.HUMANO);

        double aciertoAI = servicio.calcularPorcentajeAciertoMedioPorTipo(TipoAgente.AI);
        double aciertoHumano = servicio.calcularPorcentajeAciertoMedioPorTipo(TipoAgente.HUMANO);

        logger.info("Tiempo medio AI: " +  tiempoMedioAI);
        logger.info("Tiempo medio Humano: "+ tiempoMedioHumano);
        logger.info("Porcentaje acierto medio AI: "+ aciertoAI);
        logger.info("Porcentaje acierto medio Humano: "+ aciertoHumano);

        List<InteraccionAgente> topInteracciones = servicio.obtenerInteraccionesAciertoMayorQueOrdenadas(90.0);
        logger.info("Interacciones mayor acierto"+ topInteracciones.size());

        InteraccionAgente interaccionagentemejorvaloracion = servicio.obtenerInteraccionConMejorValoracion();
        logger.info("Interacción con mejor valoración: "+ interaccionagentemejorvaloracion);

        Map<TipoAgente, List<InteraccionAgente>> agrupadasAI = servicio.agruparInteraccionesPorTipo(interacciones, TipoAgente.AI);
        Map<TipoAgente, List<InteraccionAgente>> agrupadasHumano = servicio.agruparInteraccionesPorTipo(interacciones, TipoAgente.HUMANO);

        logger.info("Interacciones AI agrupadas: "+ agrupadasAI.get(TipoAgente.AI).size());
        logger.info("Interacciones Humano agrupadas: "+ agrupadasHumano.get(TipoAgente.HUMANO).size());

        util.crearRegistrosDesdeJSON(rutaJson, interacciones);
        util.grabarFicheroCsv(rutaCsv, interacciones);
        logger.info("Archivos JSON y CSV generados correctamente.");

        boolean borrada = servicio.eliminarInteraccion(3);
        logger.info("Interacción eliminada: "+ borrada);


    }
}
