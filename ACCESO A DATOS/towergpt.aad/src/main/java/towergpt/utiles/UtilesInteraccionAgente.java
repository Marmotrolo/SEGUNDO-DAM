package towergpt.utiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import towergpt.modelo.InteraccionAgente;
import towergpt.servicio.File;
import towergpt.servicio.FileWriter;
import towergpt.servicio.PrintWriter;

public class UtilesInteraccionAgente {
		

	private static final Logger logger = LogManager.getLogger(UtilesInteraccionAgente.class);

		
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
		        		    a.getValoracion()

		        			);
		        }

		    } catch (IOException e) {
		        System.out.println("IOException");
		    } finally {
		        if (out != null)
		            out.close();
		    }}}
		



