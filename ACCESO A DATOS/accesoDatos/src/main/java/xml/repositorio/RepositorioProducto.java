package xml.repositorio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.modelo.Producto;


public class RepositorioProducto {
private static final Logger logger = LogManager.getLogger(RepositorioProducto.class);

	
	private  List <Producto> productos;
	

	public RepositorioProducto(List<Producto> productos) {
		super();
		this.productos = productos;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
