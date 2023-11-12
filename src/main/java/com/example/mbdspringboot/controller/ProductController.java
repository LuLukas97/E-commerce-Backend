package com.example.mbdspringboot.controller;


import com.example.mbdspringboot.model.Product;
import com.example.mbdspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RestController
public class ProductController {


    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /*@GetMapping("/products")
    public Optional<Product> getProductByName(@RequestParam(value="id") Long id){
        return productService.getProductById(id);
    }*/

    @GetMapping("/test")
    public String hej(){
        System.out.println("hej");
        return null;
    }

    @GetMapping("/products/all")
    public List<Product> getAllProducts(){
        System.out.println("hej");
        return productService.findAll();
    }

    @GetMapping("/products")
    public List<Product> getCategory(@RequestParam String category) {
        return productService.findByCategory(category);
    }


}
