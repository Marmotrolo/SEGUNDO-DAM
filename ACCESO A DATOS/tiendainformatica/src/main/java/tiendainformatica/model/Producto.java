package tiendainformatica.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;

	private double precio;
	@OneToOne(mappedBy = "producto", cascade = CascadeType.ALL)

	private Garantia garantia;
	// bidireccional
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	// unidireccional
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	@ManyToMany(mappedBy = "productos", cascade = CascadeType.ALL)

	private Set<Cliente> clientes;

	public void addCliente(Cliente c) {
		this.clientes.add(c);
		if (!c.getProductos().contains(c)) {
			c.getProductos().add(this);
		}
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto() {
		super();
	}

}
