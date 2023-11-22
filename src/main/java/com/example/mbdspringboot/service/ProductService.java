package com.example.mbdspringboot.service;

import com.example.mbdspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mbdspringboot.repository.ProductRepository;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

}
