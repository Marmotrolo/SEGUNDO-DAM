package towergpt.utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import towergpt.modelo.InteraccionAgente;
import towergpt.repositorio.Repositoriointeracciones;

public class UtilesInteraccionAgente {
		

	private static final Logger logger = LogManager.getLogger(UtilesInteraccionAgente.class);

		
	public void crearRegistrosDesdeJSON(String ruta, Set<InteraccionAgente>interacciones) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(interacciones);
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(ruta);
            fichero.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.out.println("Error al escribir fichero json de interacciones");
                }

            }

        }
	}
	public void grabarFicheroCsv(String ruta, Set<InteraccionAgente> interacciones) {
	    interacciones = Repositoriointeracciones.getInteracciones();
		PrintWriter out = null;
	    File rutagrande = new File(ruta);

	    try {
	        FileWriter ficheroSalida = new FileWriter(rutagrande);
	        out = new PrintWriter(ficheroSalida);

	        out.println("Id,TipoAgente,Peticion,Respuesta,Valoracion,Porcentaje_Acierto");

	        for (InteraccionAgente interaccionagente : interacciones) {
	        	out.printf(Locale.US, "%d,%s,%s,%s,%f,%f,%f",
	        			interaccionagente.getId(),
	        			interaccionagente.getTipoAgente(),
	        			interaccionagente.getPeticion(),
	        			interaccionagente.getRespuesta(),
	        			interaccionagente.getValoracion(),
	        			interaccionagente.getPorcentajeAcierto(),
	        			interaccionagente.getTiempoResolucion()
	        		);
	        }

	    } catch (IOException e) {
	        System.out.println("IOException");
	    } finally {
	        if (out != null)
	            out.close();
	    }
	}

}

	



