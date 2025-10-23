package pokemon;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utiles.ManejaPokemons;
import utiles.EscribirPokemonCsv;

public class GestionaPokemons {

	private static final Logger logger = LogManager.getLogger(GestionaPokemons.class);
	
	public static void main(String[] args) {


		ManejaPokemons manejaPokemonJson = new ManejaPokemons();
		EscribirPokemonCsv escribirP = new EscribirPokemonCsv();

		String ruta = "src\\main\\resources\\pokemon.json";
		String rutaCsv = "src\\main\\resources\\pokemon.csv";
		
		
		
		
		
		try {
			manejaPokemonJson.leeCsv(rutaCsv);
			logger.info(manejaPokemonJson.leeCsv(rutaCsv));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
