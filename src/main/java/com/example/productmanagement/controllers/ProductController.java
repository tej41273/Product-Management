package com.example.productmanagement.controllers;



import com.example.productmanagement.entities.Product;
import com.example.productmanagement.repos.ProductRepository;

import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    @Cacheable("product-cache")
    @Transactional(readOnly = true)
    public Product getProduct(@PathVariable("id") int id){
        return productRepository.findById(id).get();
    }

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    @CacheEvict("product-cache")
    public void deleteProduct(@PathVariable("id") int id){
        productRepository.deleteById(id);
    }



}
