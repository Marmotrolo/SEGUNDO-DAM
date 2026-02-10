package controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.TiendaService;
import tiendainformatica.model.Categoria;
import tiendainformatica.model.Cliente;
import tiendainformatica.model.Empleado;
import tiendainformatica.model.Fabricante;
import tiendainformatica.model.Garantia;
import tiendainformatica.model.Producto;

public class TiendaMain {

	// Instanciamos el logger para esta clase
	private static final Logger logger = LogManager.getLogger(TiendaMain.class);

	public static void main(String[] args) {
		TiendaService servicio = new TiendaService();

		try {
			logger.info("PARTE 1: OPERACIONES CRUD");

			logger.info("--- 1. CREANDO ENTIDADES ---");

			Fabricante asus = new Fabricante("ASUS", "Taiwán");
			Fabricante logitech = new Fabricante("Logitech", "Suiza");
			Fabricante samsung = new Fabricante("Samsung", "Corea del Sur");
			servicio.guardar(asus);
			servicio.guardar(logitech);
			servicio.guardar(samsung);
			logger.info("Fabricantes creados");

			Categoria componentes = new Categoria("Componentes PC");
			Categoria perifericos = new Categoria("Periféricos");
			Categoria monitores = new Categoria("Monitores");
			servicio.guardar(componentes);
			servicio.guardar(perifericos);
			servicio.guardar(monitores);
			logger.info("Categorías creadas");

			// Crear Productos y sus Garantías
			Producto gpu = new Producto("RTX 4080", 1150.0);
			gpu.setFabricante(asus);
			gpu.setCategoria(componentes);
			gpu.setClientes(new HashSet<>());

			Garantia garantiaGPU = new Garantia(LocalDate.now().plusYears(3),
					"Cubre fallos de fábrica y defectos de fabricación", gpu);
			gpu.setGarantia(garantiaGPU);
			servicio.guardar(gpu);
			logger.info("Producto GPU con garantía creado");

			Producto teclado = new Producto("Teclado Mecánico K95", 179.99);
			teclado.setFabricante(logitech);
			teclado.setCategoria(perifericos);
			teclado.setClientes(new HashSet<>());

			Garantia garantiaTeclado = new Garantia(LocalDate.now().plusYears(2), "Garantía limitada del fabricante",
					teclado);
			teclado.setGarantia(garantiaTeclado);
			servicio.guardar(teclado);
			logger.info("Producto Teclado con garantía creado");

			Producto monitor = new Producto("Monitor Gaming 27", 349.99);
			monitor.setFabricante(samsung);
			monitor.setCategoria(monitores);
			monitor.setClientes(new HashSet<>());

			Garantia garantiaMonitor = new Garantia(LocalDate.now().plusYears(1), "Garantía estándar de 1 año",
					monitor);
			monitor.setGarantia(garantiaMonitor);
			servicio.guardar(monitor);
			logger.info("Producto Monitor con garantía creado");

			// Clientes
			Cliente cliente1 = new Cliente("Juan Pérez", "juan.perez@email.com");
			cliente1.setProductos(new HashSet<>());
			cliente1.getProductos().add(gpu);
			cliente1.getProductos().add(teclado);
			servicio.guardar(cliente1);
			logger.info("Cliente 1 creado con 2 productos");

			// Empleados
			Empleado emp1 = new Empleado("Carlos Rodríguez", "Vendedor", 1800.0);
			servicio.guardar(emp1);
			logger.info("Empleados creados");

			logger.info("--- 2. ACTUALIZANDO ENTIDADES ---");
			gpu.setPrecio(1099.99);
			servicio.guardar(gpu);
			logger.info("Precio de GPU actualizado");

			logger.info("PARTE 2: CONSULTAS HQL Y CRITERIA");

			logger.info("--- 2.1.a: Producto más caro ---");
			Producto productoMasCaro = servicio.getProductoDAO().obtenerProductoMasCaro();
			if (productoMasCaro != null) {
				logger.info("Producto: {} - Precio: €{}", productoMasCaro.getNombre(), productoMasCaro.getPrecio());
			}

			logger.info("--- 2.2: Actualización con CriteriaBuilder ---");
			int actualizados = servicio.getProductoDAO().actualizarPrecioConCriteria(teclado.getId(), 169.99);
			logger.info("Productos actualizados con Criteria: {}", actualizados);

		} catch (Exception e) {
			logger.error("Se ha producido un error en la ejecución: ", e);
		}
	}
}