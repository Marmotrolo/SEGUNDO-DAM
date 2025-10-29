package towergpt.modelo;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class InteraccionAgente implements Comparable <InteraccionAgente> {

	 	private int id;
	    private TipoAgente tipoAgente; 
	    private String peticion;
	    private String respuesta;
	    private double valoracion;
	    private double porcentajeAcierto;
	    private double tiempoResolucion; 

	    public InteraccionAgente(TipoAgente tipoAgente, String peticion, String respuesta,
	                             double valoracion, double porcentajeAcierto, double tiempoResolucion) {
	        this.id = id;
	        this.tipoAgente = tipoAgente;
	        this.peticion = peticion;
	        this.respuesta = respuesta;
	        this.valoracion = valoracion;
	        this.porcentajeAcierto = porcentajeAcierto;
	        this.tiempoResolucion = tiempoResolucion;
	    }
	    
	  



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public TipoAgente getTipoAgente() {
			return tipoAgente;
		}



		public void setTipoAgente(TipoAgente tipoAgente) {
			this.tipoAgente = tipoAgente;
		}



		public String getPeticion() {
			return peticion;
		}



		public void setPeticion(String peticion) {
			this.peticion = peticion;
		}



		public String getRespuesta() {
			return respuesta;
		}



		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}



		public double getValoracion() {
			return valoracion;
		}



		public void setValoracion(double valoracion) {
			this.valoracion = valoracion;
		}



		public double getPorcentajeAcierto() {
			return porcentajeAcierto;
		}



		public void setPorcentajeAcierto(double porcentajeAcierto) {
			this.porcentajeAcierto = porcentajeAcierto;
		}



		public double getTiempoResolucion() {
			return tiempoResolucion;
		}



		public void setTiempoResolucion(double tiempoResolucion) {
			this.tiempoResolucion = tiempoResolucion;
		}



		@Override
		public int compareTo(InteraccionAgente o) {

			return Double.compare(this.porcentajeAcierto, o.porcentajeAcierto);
		}





		@Override
		public String toString() {
			return "InteraccionAgente [id=" + id + ", tipoAgente=" + tipoAgente + ", peticion=" + peticion
					+ ", respuesta=" + respuesta + ", valoracion=" + valoracion + ", porcentajeAcierto="
					+ porcentajeAcierto + ", tiempoResolucion=" + tiempoResolucion + "]";
		}
	    
	    
	    
}
