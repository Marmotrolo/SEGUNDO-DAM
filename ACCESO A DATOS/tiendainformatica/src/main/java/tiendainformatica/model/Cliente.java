package tiendainformatica.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;

	private String email;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Producto> productos;

	public Cliente(String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.productos = new HashSet<>();
	}

	public Cliente() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public void addCliente(Producto p) {
		this.getProductos().add(p);
		if (!p.getClientes().contains(p)) {
			p.getClientes().add(this);
		}
	}

}
