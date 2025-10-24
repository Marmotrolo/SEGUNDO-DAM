package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import pokemon.Pokemon;

public class ManejaPokemons {

private static final Logger logger = LogManager.getLogger(ManejaPokemons.class);
	
	public Pokemon leePokemon(String rutaFichero) {
		
		Pokemon pokemon = null;
		
		try {
		  Gson gson = new Gson();
		  FileReader fichero = new FileReader(rutaFichero);
		  // Leer el archivo JSON y convertirlo a un objeto 
		  pokemon = gson.fromJson(fichero,Pokemon.class);
		  
			logger.info(pokemon);
		} catch (Exception e) {
			logger.debug("Error al leer pokemon"+e.getMessage());
		}	
		return pokemon;
	}	
	public List<Pokemon> leeCsv (String rutaFichero) throws FileNotFoundException{
		List<Pokemon> listapokemon= new ArrayList<Pokemon>();
			
			FileReader fichero = new FileReader(rutaFichero);
			Scanner in = new Scanner(fichero);
			while(in.hasNextLine()) {
				String linea= in.nextLine();
				String[] palabras= linea.split(",");
				
				int id= Integer.parseInt(palabras[0]) ;
				String nompokemon= palabras[1];
				String tipo= palabras[2];
				float altura= Float.parseFloat( palabras[3]);
				float peso= Float.parseFloat(palabras[4]);
				String[] habilidades = palabras[5].split(";");
				String evoluciona_a= palabras[6];
				
				Pokemon pokemon = new Pokemon(id, nompokemon, tipo, habilidades, evoluciona_a, altura, peso);
				listapokemon.add(pokemon);
				
				
				}
			return listapokemon;
			}
			
		}
			
	

