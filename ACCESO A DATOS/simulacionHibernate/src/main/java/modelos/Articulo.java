package modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String titulo;
	private int numpaginainicio;
	private int numpaginafinal;

	@ManyToOne( )
	@JoinColumn(name = "revista_id")
	private Revista revista;
	
	@ManyToMany()
	private List<Autor> autores;

	public Articulo(String titulo, int numpaginainicio, int numpaginafinal) {
		super();
		this.titulo = titulo;
		this.numpaginainicio = numpaginainicio;
		this.numpaginafinal = numpaginafinal;
		this.autores= new ArrayList<>();
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumpaginainicio() {
		return numpaginainicio;
	}

	public void setNumpaginainicio(int numpaginainicio) {
		this.numpaginainicio = numpaginainicio;
	}

	public int getNumpaginafinal() {
		return numpaginafinal;
	}

	public void setNumpaginafinal(int numpaginafinal) {
		this.numpaginafinal = numpaginafinal;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	
	

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Articulo() {
		super();
	}

	public void addAutor(Autor a2) {
this.getAutores().add(a2);
if(!a2.getArticulos().contains(a2)) {
	a2.getArticulos().add(this);
}
	}
	

}
