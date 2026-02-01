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
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private double precio;
	@OneToOne(mappedBy="producto", cascade=CascadeType.ALL)
	
	private Garantia garantia;
	//bidireccional
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	
	@ManyToOne
	@JoinColumn(name="fabricante_id")
	private Fabricante fabricante;
	
	@ManyToMany(mappedBy = "productos Comprados")
	private Set<Cliente> clientes;
}
