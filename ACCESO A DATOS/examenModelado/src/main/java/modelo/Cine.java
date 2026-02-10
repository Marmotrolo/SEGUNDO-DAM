package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cines")
public class Cine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombrerevista;
	private String ubicacion;

	@OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
	private List<Sala> salas;

	public Cine(String nombrerevista, String ubicacion) {
		super();
		this.id = id;
		this.nombrerevista = nombrerevista;
		this.ubicacion = ubicacion;
		this.salas = new ArrayList<>();
	}

	public Cine() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrerevista() {
		return nombrerevista;
	}

	public void setNombrerevista(String nombrerevista) {
		this.nombrerevista = nombrerevista;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public void addSala(Sala s2) {
		this.getSalas().add(s2);
		s2.setCine(this);

	}

}
