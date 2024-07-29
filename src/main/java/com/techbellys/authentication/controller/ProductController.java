package com.techbellys.authentication.controller;

import com.techbellys.authentication.model.Product;
import com.techbellys.authentication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
        return productService.updateProduct(id, productRequest);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductsById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/list")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
