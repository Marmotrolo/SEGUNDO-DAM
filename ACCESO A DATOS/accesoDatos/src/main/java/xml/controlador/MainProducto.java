package xml.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.modelo.Pelicula;
import xml.modelo.Producto;
import xml.servicio.ServicioProducto;
import xml.utiles.XMLdomPeliculas;
import xml.utiles.XMLdomProductos;

public class MainProducto {
	private static final Logger logger= LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		XMLdomProductos XMLdomProductos= new XMLdomProductos();
		
		try {
			List<Producto> productos = XMLdomProductos.leerpodructosDesdeXML("Productos.xml");
			ServicioProducto servicio = new ServicioProducto(productos);
			List <Producto> sinstock= servicio.obtieneproductosinferiorstock(5);
			servicio.generaJSONnoenventa(sinstock);
			
			logger.info(productos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
