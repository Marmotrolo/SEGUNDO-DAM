package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Product;

@Repository
public interface IProductoRepositorio extends JpaRepository<Product,Long> {

}
