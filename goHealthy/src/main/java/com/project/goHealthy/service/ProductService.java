package com.project.goHealthy.service;

import com.project.goHealthy.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    List<Product> getAllProducts();

    List<Product> getAllProductsPaginated(Integer pageNumber, Integer pageSize, String sortBy);

    Optional<Product> findByName(String name);

    Optional<Product> findById(Integer id);

    Product save(Product product);

    Product update(Product product, Integer id);

    void delete(Integer id);

    List<Product> getByNameContaining(String name);

}
