package modelos;

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
@Table(name = "revistas")
public class Revista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombrerevista;
	private int numerorevista;
	private LocalDate fecha;
	private int unidadesimpresas;

	@OneToMany(mappedBy="revista", cascade =  CascadeType.ALL)
	private List<Articulo> articulos;

	public Revista( String nombrerevista, int numerorevista, LocalDate fecha, int unidadesimpresas) {
		super();
		this.id = id;
		this.nombrerevista = nombrerevista;
		this.numerorevista = numerorevista;
		this.fecha = fecha;
		this.unidadesimpresas = unidadesimpresas;
		this.articulos = new ArrayList<Articulo>();
	}

	

	public Revista(String nombrerevista, int numerorevista, LocalDate fecha) {
		super();
		this.id = id;

		this.nombrerevista = nombrerevista;
		this.numerorevista = numerorevista;
		this.fecha = fecha;
		this.articulos = new ArrayList<Articulo>();

	}



	public Revista() {
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

	public int getNumerorevista() {
		return numerorevista;
	}

	public void setNumerorevista(int numerorevista) {
		this.numerorevista = numerorevista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getUnidadesimpresas() {
		return unidadesimpresas;
	}

	public void setUnidadesimpresas(int unidadesimpresas) {
		this.unidadesimpresas = unidadesimpresas;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}



	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}



	public void addArticulo(Articulo ar2) {
		this.getArticulos().add(ar2);
		ar2.setRevista(this);
		
	}
	

}
