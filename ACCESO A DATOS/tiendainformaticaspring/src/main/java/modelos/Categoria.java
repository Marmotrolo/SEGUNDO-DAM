package modelos;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Entidad Categoria - Representa las categorías de productos
 * Relación 1:N con Producto (Una categoría tiene muchos productos)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nombre;

	@Column(length = 500)
	private String descripcion;

	// Relación OneToMany: Una categoría tiene muchos productos
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Producto> productos = new ArrayList<>();

	// Constructor personalizado
	public Categoria(String nombre) {
		this.nombre = nombre;
		this.productos = new ArrayList<>();
	}

	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = new ArrayList<>();
	}

	// Métodos de utilidad para mantener bidireccionalidad
	public void addProducto(Producto producto) {
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		this.productos.add(producto);
		producto.setCategoria(this);
	}

	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
		producto.setCategoria(null);
	}
}
