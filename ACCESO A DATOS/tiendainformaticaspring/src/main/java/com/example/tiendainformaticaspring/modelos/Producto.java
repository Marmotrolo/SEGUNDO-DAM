package com.example.tiendainformaticaspring.modelos;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Producto - Representa los productos de la tienda informática
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Double precio;
	
	@Column(length = 500)
	private String descripcion;
	
	// Relación ManyToOne: Muchos productos pertenecen a una categoría (1:N)
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	// Relación ManyToMany: Muchos productos pueden ser comprados por muchos clientes (N:M)
	@ManyToMany(mappedBy = "productos")
	private Set<Cliente> clientes = new HashSet<>();

	// Constructor personalizado
	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.clientes = new HashSet<>();
	}

	public Producto(String nombre, Double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.clientes = new HashSet<>();
	}

	// Métodos de utilidad para mantener bidireccionalidad
	public void addCliente(Cliente cliente) {
		if (this.clientes == null) {
			this.clientes = new HashSet<>();
		}
		this.clientes.add(cliente);
		cliente.getProductos().add(this);
	}

	public void removeCliente(Cliente cliente) {
		this.clientes.remove(cliente);
		cliente.getProductos().remove(this);
	}
	
	
}
