package modelos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Cliente - Representa los clientes de la tienda
 * Relación N:M con Producto (Muchos clientes compran muchos productos)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private String telefono;

	// Relación ManyToMany: Muchos clientes pueden comprar muchos productos
	@ManyToMany
	private Set<Producto> productos = new HashSet<>();

	// Constructor personalizado
	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.productos = new HashSet<>();
	}

	public Cliente(String nombre, String email, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.productos = new HashSet<>();
	}

	// Métodos de utilidad para mantener bidireccionalidad
	public void addProducto(Producto producto) {
		if (this.productos == null) {
			this.productos = new HashSet<>();
		}
		this.productos.add(producto);
		producto.getClientes().add(this);
	}

	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
		producto.getClientes().remove(this);
	}
}
