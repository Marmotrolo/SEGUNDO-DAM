package xml.repositorio;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.modelo.Producto;


public class RepositorioProducto {
private static final Logger logger = LogManager.getLogger(RepositorioProducto.class);

	
	private  Set <Producto> productos;
	

	public RepositorioProducto() {
		super();
		this.productos = new HashSet<>() ;
	}
	
}
