package com.example.tiendainformaticaspring.services;

import java.util.List;

import com.example.tiendainformaticaspring.modelos.Categoria;

public interface CategoriaService {
	
	// CRUD básico
	List<Categoria> findAll();
	Categoria findById(Long id);
	Categoria save(Categoria categoria);
	void deleteById(Long id);
	
	// Búsquedas
	Categoria findByNombre(String nombre);
	List<Categoria> findByNombreContaining(String nombre);
	
	// Modificar descripción
	Categoria actualizarDescripcion(Long id, String nuevaDescripcion);
}
