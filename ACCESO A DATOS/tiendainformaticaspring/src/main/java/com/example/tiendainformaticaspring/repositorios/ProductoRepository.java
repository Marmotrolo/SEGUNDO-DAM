package com.example.tiendainformaticaspring.repositorios;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendainformaticaspring.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findAll();
    Set<Producto> findByCategoriaNombre(String nombre);
    Producto findProductById(long id);
}
