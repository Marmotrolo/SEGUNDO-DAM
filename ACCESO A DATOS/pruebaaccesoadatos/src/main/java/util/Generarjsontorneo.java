package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Enfrentamiento;

public class Generarjsontorneo {
	public void generaJSONnoenventa(List<Enfrentamiento> enfrentamientos) throws Exception {

	    String rutaSalida = "src/main/resources/" + "jsontorneo.json";
		
	    Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	    
	    try (FileWriter writer = new FileWriter(rutaSalida)) {
	        gson.toJson(enfrentamientos, writer);
	        System.out.println(("CREADO"));
	       
	    } catch (IOException e) {
	    	 System.out.println(("no CREADO"));	    }
	}
}
