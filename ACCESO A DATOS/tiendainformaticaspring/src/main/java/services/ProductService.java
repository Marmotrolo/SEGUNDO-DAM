package services;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import modelos.Producto;


@Service
public interface ProductService {
		List<Producto>  findAll();
	    Set<Producto> findByCategory(String category);
	    public Producto createProduct(Producto product) ;
	    public Producto updateProduct(Long id, Producto product);
	    
	    public Producto findProductById(long id);
}
