package com.example.mbdspringboot.repository;

import com.example.mbdspringboot.model.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends MongoRepository<Reviews, String> {


    List<Reviews> findByProduct(ObjectId productId);
}
