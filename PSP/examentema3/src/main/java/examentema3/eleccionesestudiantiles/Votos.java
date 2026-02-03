package examentema3.eleccionesestudiantiles;

import java.util.HashMap;
import java.util.Map;

public class Votos {
	private Map<String, String> votosestudiantiles;

	public Votos() {
		super();
		this.votosestudiantiles = new HashMap<String, String>();
	}
	public synchronized String votar(String votoestudiante) {
		String resultado = "";

		String[] votoestudianteslip = votoestudiante.split(":::");

		String dni = votoestudianteslip[0].trim();
		String candidato = votoestudianteslip[1].trim();
		
		 
			
				votosestudiantiles.put(dni, candidato);
				resultado = "Su voto ha sido registrado: " + dni +  " " + candidato;

			
			return resultado;
		}
	public Map<String, String> getVotosestudiantiles() {
		return votosestudiantiles;
	}
	public void setVotosestudiantiles(Map<String, String> votosestudiantiles) {
		this.votosestudiantiles = votosestudiantiles;
	}
	public void recorrevotos() {
		  int contadorregistros=0;
		   for (Map.Entry<String, String> entry : votosestudiantiles.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				contadorregistros++;
			System.out.println("Voto "+contadorregistros+": "+ key + ", " + val   );	
			}
	}
	
}
