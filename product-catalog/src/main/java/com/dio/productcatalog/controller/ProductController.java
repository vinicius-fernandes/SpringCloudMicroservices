package com.dio.productcatalog.controller;


import com.dio.productcatalog.exceptions.ProductNotFoundException;
import com.dio.productcatalog.model.Product;
import com.dio.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository ;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping(value="/{id}")
    public Product findByID(@PathVariable Long id) throws  ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }
}
