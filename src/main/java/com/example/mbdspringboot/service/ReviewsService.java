package com.example.mbdspringboot.service;

import com.example.mbdspringboot.model.Reviews;
import com.example.mbdspringboot.repository.ReviewsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository){
        this.reviewsRepository = reviewsRepository;
    }

    public List<Reviews> getReviewsByProductId(String productId) {
        ObjectId objectId = new ObjectId(productId);
        return reviewsRepository.findByProduct(objectId);
    }

}
