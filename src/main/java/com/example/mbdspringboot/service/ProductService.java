package com.example.mbdspringboot.service;

import com.example.mbdspringboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.mbdspringboot.repository.ProductRepository;
import java.util.List;

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

    public List<Product> searchByCategoryAndFilter(String category, String filterType) {
        List<Product> products;

        switch (filterType) {
            case "rating": // highest rating
                products = productRepository.findByCategoryAndTotalRatingGreaterThan(category, 0, Sort.by(Sort.Direction.DESC, "totalRating"));
                return products;
            case "highest": // highest price
                products = productRepository.findByCategoryOrderByValuePriceDesc(category);
                return products;
            case "lowest": // lowest price
                products = productRepository.findByCategoryOrderByValuePriceAsc(category);
                return products;
            default:
                //products = productRepository.findByCategory(category);
                //return products;
        } // Need to add most reviews case aswell

       // return products;
        return null;
    }

}
