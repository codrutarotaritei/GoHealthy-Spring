package com.project.goHealthy.controller;

import com.project.goHealthy.entity.Product;
import com.project.goHealthy.exception.ProductNotFoundException;
import com.project.goHealthy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
@ControllerAdvice
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProductsPaginated(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "50") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(productService.getAllProductsPaginated(pageNumber, pageSize, sortBy));
    }

    @GetMapping("/findByName")
    public ResponseEntity<Product> findByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name <" + name + "> not found")));
    }

    @GetMapping("/findById")
    public ResponseEntity<Product> findById(@RequestParam Integer id) {
        return ResponseEntity.ok(productService.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id <" + id + "> not found")));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(
            @RequestBody Product product,
            @PathVariable("id") Integer id) {

        Optional<Product> productData = productService.findById(id);

        if (productData.isPresent()) {
            Product productToBeChanged = productData.get();
            productToBeChanged.setName(product.getName());
            productToBeChanged.setIngredients(product.getIngredients());
            productToBeChanged.setPrice(product.getPrice());
            productToBeChanged.setPictureUrl(product.getPictureUrl());
            return new ResponseEntity<>(productService.save(productToBeChanged), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Product> delete(Integer id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByNameContaining")
    public ResponseEntity<List<Product>> findByNameContaining(@RequestParam String name) {
        return ResponseEntity.ok(productService.getByNameContaining(name));
    }
}
