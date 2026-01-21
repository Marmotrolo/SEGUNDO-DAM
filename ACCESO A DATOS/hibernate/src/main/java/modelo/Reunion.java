package modelo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idSala")
	private Sala sala;
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReunion; 
//Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="fecha")
	private LocalDateTime fecha;
	// @Column(name="asunto")
	private String asunto; 
	@ManyToMany(mappedBy="reuniones")
	Set<Persona> personas;
// Generamos el constructor sin parámetros y los métodos get/set
	public int getIdReunion() {
		return idReunion;
	}
	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Set<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	public void addPersona(Persona p) {
		this.personas.add(p);
		if(!p.getReuniones().contains(p))
		{
			p.getReuniones().add(this);
		}
	}
	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", fecha=" + fecha + ", asunto=" + asunto + "]";
	}


	public Reunion(Sala sala, LocalDateTime fecha, String asunto) {
		super();
		this.sala = sala;
		this.fecha = fecha;
		this.asunto = asunto;
		this.personas = new HashSet<Persona>();
	}
	public Reunion() {
		super();
	}
	
	
}
