package xml.servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ejerciciorepaso2.repositorio.RepositorioConversaciones;
import xml.modelo.Producto;
import xml.repositorio.RepositorioProducto;
import xml.utiles.XMLdomEmpleado;
import xml.utiles.XMLdomProductos;


public class ServicioProducto {
	private static final Logger logger= LogManager.getLogger(XMLdomEmpleado.class);

	RepositorioProducto repo ;
	String rutaFichero= "src\\main\\resources\\";
	
	
	
	public ServicioProducto( List<Producto> productos) {
		super();
		this.repo = new RepositorioProducto(productos);
	}

	public List<Producto> obtieneproductosinferiorstock ( int numerostock ) throws Exception {

		List<Producto> listaproductosinferiorstock= new ArrayList<>();
		List<Producto> listaproductos = repo.getProductos();
		
		for (Producto producto : listaproductos) {
			if(producto.getStock()<numerostock) {
				listaproductosinferiorstock.add(producto);
			}
		}
		
		
		return listaproductosinferiorstock;
		
		
		
	}
	
	public void retiraDeVentaProductos ( List<Producto> listaproductos ){
		
		for (Producto producto : listaproductos) {
			if(producto.getStock()<5) {
				producto.setEnventa(false);
			}
		}
		
		
	}
	
	public List<Producto> obtieneproductosstockmenor5 (List<Producto> listaproductos) {
		List<Producto> listaproductosinferiora5 = new ArrayList<>();

		for (Producto producto : listaproductos) {
			if(producto.getStock()<5) {
				listaproductosinferiora5.add(producto);
			}
		}
		return listaproductosinferiora5;
		
		
	}
	public void generaJSONnoenventa(List<Producto> p) throws Exception {

	    String rutaSalida = rutaFichero + "productosNOenVenta.json";
		
	    Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	    String rutasalida= rutaFichero + "productosNOenventa.json";
	    
	    try (FileWriter writer = new FileWriter(rutaSalida)) {
	        gson.toJson(p, writer);
	        logger.info("CREADO");
	       
	    } catch (IOException e) {
	        logger.info("NO CREADO");
	    }

	}
	//public void escribeEmpleadosEnXML(String nombreFichero, List<Producto> empleados) {
		
	}

	

