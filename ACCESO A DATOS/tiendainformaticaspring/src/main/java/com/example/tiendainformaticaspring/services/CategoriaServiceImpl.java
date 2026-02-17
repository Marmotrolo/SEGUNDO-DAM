package com.example.tiendainformaticaspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tiendainformaticaspring.modelos.Categoria;
import com.example.tiendainformaticaspring.repositorios.CategoriaRepository;

import exceptions.ProductNotFoundException;


@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id)
			.orElseThrow(() -> new ProductNotFoundException("Categoría no encontrada con ID: " + id));
	}

	@Override
	public Categoria save(Categoria categoria) {
		// Verificar que no existe ya una categoría con ese nombre
		if (categoria.getId() == null && categoriaRepository.existsByNombre(categoria.getNombre())) {
			throw new IllegalArgumentException("Ya existe una categoría con el nombre: " + categoria.getNombre());
		}
		return categoriaRepository.save(categoria);
	}

	@Override
	public void deleteById(Long id) {
		if (!categoriaRepository.existsById(id)) {
			throw new ProductNotFoundException("No se puede eliminar. Categoría no encontrada con ID: " + id);
		}
		categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria findByNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre)
			.orElseThrow(() -> new ProductNotFoundException("Categoría no encontrada con nombre: " + nombre));
	}

	@Override
	public List<Categoria> findByNombreContaining(String nombre) {
		return categoriaRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public Categoria actualizarDescripcion(Long id, String nuevaDescripcion) {
		Categoria categoria = findById(id);
		categoria.setDescripcion(nuevaDescripcion);
		return categoriaRepository.save(categoria);
	}
}
