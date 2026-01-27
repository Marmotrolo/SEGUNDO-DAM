package flythread;

import java.util.HashMap;
import java.util.Map;

public class MapaFlyThread {
	private Map<Integer, String> reservaasientos;

	public MapaFlyThread() {
		super();
		this.reservaasientos = new HashMap<Integer, String>();
	}

	public Map<Integer, String> getReservaasientos() {
		return reservaasientos;
	}

	public void setReservaasientos(Map<Integer, String> reservaasientos) {
		this.reservaasientos = reservaasientos;
	}

	@Override
	public String toString() {
		return "MapaFlyThread [reservaasientos=" + reservaasientos + "]";
	}

	public synchronized String reservarasiento(String asientocliente) {
		String resultado = "";

		String[] asientoclientesplit = asientocliente.split("y");

		int numero = Integer.parseInt(asientoclientesplit[0].trim());
		String nombre = asientoclientesplit[1].trim();

		 
			if (!reservaasientos.containsKey(numero)) {
				reservaasientos.put(numero, nombre);
				resultado = "Su asiento ha sido reservado: " + numero +  " " + nombre;

			} else {
				resultado = "Este asiento ya está reservado mamon , mira " + reservaasientos.get(numero);

			}
			return resultado;
		}
	

}
