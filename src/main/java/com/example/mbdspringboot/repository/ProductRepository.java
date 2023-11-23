package com.example.mbdspringboot.repository;

import com.example.mbdspringboot.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);

    List<Product> findByCategoryAndTotalRatingGreaterThan(String category, int totalRating, Sort sort);
    List<Product> findByCategoryOrderByValuePriceDesc(String category);
    List<Product> findByCategoryOrderByValuePriceAsc(String category);

    Product findBySlug(String slug);
}
