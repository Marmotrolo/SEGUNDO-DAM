package com.example.tiendainformaticaspring.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendainformaticaspring.modelos.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	// Buscar por email (exacto)
	Optional<Cliente> findByEmail(String email);
	
	// Buscar por nombre que contenga (parcial)
	List<Cliente> findByNombreContainingIgnoreCase(String nombre);
	
	// Verificar si existe por email
	boolean existsByEmail(String email);
}
