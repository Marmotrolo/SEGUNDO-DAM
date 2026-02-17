package com.example.tiendainformaticaspring.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendainformaticaspring.modelos.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	// Buscar por nombre (exacto)
	Optional<Categoria> findByNombre(String nombre);
	
	// Buscar por nombre que contenga (parcial)
	List<Categoria> findByNombreContainingIgnoreCase(String nombre);
	
	// Verificar si existe por nombre
	boolean existsByNombre(String nombre);
}
