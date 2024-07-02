package com.example.productmanagement.controllers;



import com.example.productmanagement.entities.Product;
import com.example.productmanagement.repos.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        productRepository.deleteById(id);
    }
}
