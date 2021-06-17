package com.project.goHealthy.repository;

import com.project.goHealthy.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    List<Product> findByNameContaining(String name);
}
