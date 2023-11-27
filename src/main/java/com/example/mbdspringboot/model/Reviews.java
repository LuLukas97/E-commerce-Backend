package com.example.mbdspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Document("reviews")
public class Reviews {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String comment;
    private Integer rating;
    private Date date;
    @Field(targetType = FieldType.OBJECT_ID)
    private String product;

    public Reviews(String id, String name, String comment, Integer rating, Date date, String product) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
