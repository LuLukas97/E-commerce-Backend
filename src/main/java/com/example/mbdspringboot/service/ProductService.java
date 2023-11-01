package com.example.mbdspringboot.service;

import com.example.mbdspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mbdspringboot.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

   /* public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }*/

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
