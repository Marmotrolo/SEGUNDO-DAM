package services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import exceptions.ProductNotFoundException;
import modelos.Producto;
import repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductService {
	@Autowired
	private ProductoRepository productRepository;

	@Override
	public List<Producto> findAll() {
		return productRepository.findAll();
	}
   
	@Override
	public Set<Producto> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public Producto createProduct(Producto product) {
		return productRepository.save(product);
	}
	
	public Producto updateProduct(Long id, Producto product) {
		Producto pOriginal= this.findProductById(id);
		if(pOriginal != null) {
		pOriginal.setNombre(product.getNombre());
		}
		else {
			new ProductNotFoundException(id);
		}
		return productRepository.save(pOriginal);
	}
	
	

	// Método para encontrar un producto por ID
    public Producto findProductById(long id) {
        Optional<Producto> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new ProductNotFoundException(id));
    }
}
