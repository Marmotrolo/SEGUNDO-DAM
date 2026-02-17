package com.example.tiendainformaticaspring.controllers; // Cambia esto
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tiendainformaticaspring.modelos.Categoria;
import com.example.tiendainformaticaspring.modelos.Cliente;
import com.example.tiendainformaticaspring.modelos.Producto;
import com.example.tiendainformaticaspring.services.CategoriaService;
import com.example.tiendainformaticaspring.services.ClienteService;
import com.example.tiendainformaticaspring.services.ProductService;

import exceptions.ProductNotFoundException;

@Controller
@RequestMapping("/tienda")

public class WebController {

	@Autowired
	private ProductService productoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ClienteService clienteService;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	// Listar todos (HTML)
		@GetMapping("/productos")
		public String listarProductos(Model model) {
			List<Producto> productos = productoService.findAll();
			model.addAttribute("productos", productos);
			return "productoslista";
		}

		// Ver detalle por ID (HTML)
		@GetMapping("/productos/{id}")
		public String verProducto(@PathVariable Long id, Model model) {
			Producto producto = productoService.findProductById(id);
			model.addAttribute("producto", producto);
			return "productodetalle";
		}

		// Buscar por nombre (JSON)
		@GetMapping("/productos/buscar")
		@ResponseBody
		public Map<String, Object> buscarProducto(@RequestParam String nombre) {
			Map<String, Object> respuesta = new HashMap<>();
			try {
				Producto producto = productoService.findByNombre(nombre);
				respuesta.put("exito", true);
				respuesta.put("mensaje", "Producto encontrado");
				respuesta.put("codigo", 200);
				respuesta.put("producto", producto);
			} catch (Exception e) {
				respuesta.put("exito", false);
				respuesta.put("mensaje", e.getMessage());
				respuesta.put("codigo", 404);
			}
			return respuesta;
		}

	
    
 // ==================== CATEGORÍAS ====================
	
 	// Listar todas (HTML)
 	@GetMapping("/categorias")
 	public String listarCategorias(Model model) {
 		List<Categoria> categorias = categoriaService.findAll();
 		model.addAttribute("categorias", categorias);
 		return "categoriaslista";
 	}

 	// Ver detalle por ID (HTML)
 	@GetMapping("/categorias/{id}")
 	public String verCategoria(@PathVariable Long id, Model model) {
 		Categoria categoria = categoriaService.findById(id);
 		model.addAttribute("categoria", categoria);
 		return "categoriadetalle";
 	}

 	// Buscar por nombre (JSON)
 	@GetMapping("/categorias/buscar")
 	@ResponseBody
 	public Map<String, Object> buscarCategoria(@RequestParam String nombre) {
 		Map<String, Object> respuesta = new HashMap<>();
 			Categoria categoria = categoriaService.findByNombre(nombre);
 			respuesta.put("exito", true);
 			respuesta.put("mensaje", "Categoría encontrada");
 			respuesta.put("codigo", 200);
 			respuesta.put("categoria", categoria);
 		
 		return respuesta;
 	}

 	// Actualizar descripción (JSON)
 	@PutMapping("/categorias/{id}/descripcion")
 	@ResponseBody
 	public Map<String, Object> actualizarDescripcion(@PathVariable Long id, @RequestParam String descripcion) {
 		Map<String, Object> respuesta = new HashMap<>();
 			Categoria categoria = categoriaService.actualizarDescripcion(id, descripcion);
 			respuesta.put("exito", true);
 			respuesta.put("mensaje", "Descripción actualizada");
 			respuesta.put("codigo", 200);
 			respuesta.put("categoria", categoria);
 		
 		return respuesta;
 	}
	
 // ==================== CLIENTES ====================
	
 	// Listar todos (HTML)
 	@GetMapping("/clientes")
 	public String listarClientes(Model model) {
 		List<Cliente> clientes = clienteService.findAll();
 		model.addAttribute("clientes", clientes);
 		return "clienteslista";
 	}

 	// Ver detalle por ID (HTML)
 	@GetMapping("/clientes/{id}")
 	public String verCliente(@PathVariable Long id, Model model) {
 		Cliente cliente = clienteService.findById(id);
 		model.addAttribute("cliente", cliente);
 		return "clientedetalle";
 	}

 	// Buscar por email (CADENA)
 	@GetMapping("/clientes/buscar")
 	@ResponseBody
 	public String buscarCliente(@RequestParam String email) {
 		try {
 			Cliente cliente = clienteService.findByEmail(email);
 			return "Cliente encontrado: " + cliente.getNombre() + " (" + cliente.getEmail() + ")";
 		} catch (Exception e) {
 			return "No se encontró ningún cliente con el email: " + email;
 		}
 	}

 	// Filtrar por nombre (CADENA)
 	@GetMapping("/clientes/filtrar")
 	@ResponseBody
 	public String filtrarClientes(@RequestParam String nombre) {
 		List<Cliente> clientes = clienteService.findByNombreContaining(nombre);
 		if (clientes.isEmpty()) {
 			return "No se encontraron clientes con el nombre: " + nombre;
 		}
 		StringBuilder resultado = new StringBuilder("Clientes encontrados: ");
 		for (int i = 0; i < clientes.size(); i++) {
 			resultado.append(clientes.get(i).getNombre());
 			if (i < clientes.size() - 1) {
 				resultado.append(", ");
 			}
 		}
 		return resultado.toString();
 	}

 	// Actualizar teléfono (CADENA)
 	@PutMapping("/clientes/{id}/telefono")
 	@ResponseBody
 	public String actualizarTelefono(@PathVariable Long id, @RequestParam String telefono) {
 		try {
 			Cliente cliente = clienteService.actualizarTelefono(id, telefono);
 			return "Teléfono actualizado para " + cliente.getNombre() + ": " + cliente.getTelefono();
 		} catch (Exception e) {
 			return "Error: " + e.getMessage();
 		}
 	}

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(ProductNotFoundException pnfe) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	

}
