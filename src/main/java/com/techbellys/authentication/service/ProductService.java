package com.techbellys.authentication.service;

import com.techbellys.authentication.model.Product;
import com.techbellys.authentication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(int id, Product productRequest) {
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setProductType(productRequest.getProductType());
        return repository.save(existingProduct);
    }

    public Optional<Product> getProductById(Integer id) {
        return repository.findById(id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

}
