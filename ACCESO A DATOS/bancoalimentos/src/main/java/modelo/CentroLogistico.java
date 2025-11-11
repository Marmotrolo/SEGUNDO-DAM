package modelo;

import java.util.List;

public class CentroLogistico {
	  private String id; // Identificador único del centro
	    private String nombre;
	    private String ciudad;
	    private int numeroComedores; // Número de comedores que abastece
	    private List<Trabajador> personal; // Lista de trabajadores del centro
		public CentroLogistico(String id, String nombre, String ciudad, int numeroComedores,
				List<Trabajador> personal) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.ciudad = ciudad;
			this.numeroComedores = numeroComedores;
			this.personal = personal;
		}
		
		
		public CentroLogistico() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public int getNumeroComedores() {
			return numeroComedores;
		}
		public void setNumeroComedores(int numeroComedores) {
			this.numeroComedores = numeroComedores;
		}
		public List<Trabajador> getPersonal() {
			return personal;
		}
		public void setPersonal(List<Trabajador> personal) {
			this.personal = personal;
		}
	    
	    
	    
	    
}




