package modelo;

import java.time.LocalDate;

public class Trabajador {
	 private String nombre;
	    private String dni; 
	    private String id;
	    private LocalDate fechaNacimiento;
	    private boolean esAsalariado; 
	    private CentroLogistico centroLogistico;
	
		public Trabajador(String nombre, String dni, LocalDate fechaNacimiento, boolean esAsalariado,
				CentroLogistico centroLogistico) {
			super();
			this.nombre = nombre;
			this.dni = dni;
			this.id = centroLogistico.getId();;
			this.fechaNacimiento = fechaNacimiento;
			this.esAsalariado = esAsalariado;
			this.centroLogistico = centroLogistico;
		}
		public Trabajador() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public boolean isEsAsalariado() {
			return esAsalariado;
		}
		public void setEsAsalariado(boolean esAsalariado) {
			this.esAsalariado = esAsalariado;
		}
		public CentroLogistico getCentroLogistico() {
			return centroLogistico;
		}
		public void setCentroLogistico(CentroLogistico centroLogistico) {
			this.centroLogistico = centroLogistico;
		} 
	    
	    
	    
	    
	    
}
