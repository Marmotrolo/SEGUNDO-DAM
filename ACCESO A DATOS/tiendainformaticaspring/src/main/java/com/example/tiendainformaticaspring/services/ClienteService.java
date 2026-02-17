package com.example.tiendainformaticaspring.services;

import java.util.List;

import com.example.tiendainformaticaspring.modelos.Cliente;

public interface ClienteService {
	
	// CRUD básico
	List<Cliente> findAll();
	Cliente findById(Long id);
	Cliente save(Cliente cliente);
	void deleteById(Long id);
	
	// Búsquedas
	Cliente findByEmail(String email);
	List<Cliente> findByNombreContaining(String nombre);
	
	// Modificar teléfono
	Cliente actualizarTelefono(Long id, String nuevoTelefono);
}
