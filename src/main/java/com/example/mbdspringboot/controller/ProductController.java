package com.example.mbdspringboot.controller;


import com.example.mbdspringboot.model.Product;
import com.example.mbdspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api")
public class ProductController {


    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/test")
    public String hej() {
        System.out.println("hej");
        return null;
    }

    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        System.out.println("hej");
        return productService.findAll();
    }

    @GetMapping("/products")
    public List<Product> getCategory(@RequestParam String category) {
        return productService.findByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        String slug = generateSlug(product.getName()); // You need to implement this method

        product.setSlug(slug);

        productService.saveProduct(product);

        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    private String generateSlug(String productName) {
        return productName.toLowerCase().replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-").replaceAll("-+", "-");
    }

    @GetMapping("/products/search/{slug}")
    public ResponseEntity<Product> getProductBySlug(@PathVariable String slug) {
        Product product = productService.getProductBySlug(slug);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/search")
    public List<Product> searchProductsByCategoryAndFilter(
            @RequestParam String category,
            @RequestParam String filterType
    ) {
        return productService.searchByCategoryAndFilter(category, filterType);
    }
}
