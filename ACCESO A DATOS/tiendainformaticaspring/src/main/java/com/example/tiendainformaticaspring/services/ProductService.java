package com.example.tiendainformaticaspring.services;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.tiendainformaticaspring.modelos.Producto;


@Service
public interface ProductService {
		List<Producto>  findAll();
	    Set<Producto> findByCategoriaNombre(String nombre);
	    public Producto createProduct(Producto product) ;
	    public Producto updateProduct(Long id, Producto product);
	    
	    public Producto findProductById(long id);
}
