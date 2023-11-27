package com.example.mbdspringboot.controller;


import com.example.mbdspringboot.model.Reviews;
import com.example.mbdspringboot.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api")
public class ReviewsController {

    ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/reviews/search/{productId}")
    public ResponseEntity<List<Reviews>> getReviewsByProductId(@PathVariable String productId) {
        List<Reviews> reviews = reviewsService.getReviewsByProductId(productId);
        if (reviews == null || reviews.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }

}
