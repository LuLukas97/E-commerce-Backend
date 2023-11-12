package com.example.mbdspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document("product")
public class Product {
    public enum Category {
        electronics,
        computers,
        audio,
        monitors,
        accessories,
        camera
    }

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String brand;
    private String description;
    private Integer totalRating;
    @Field(targetType = FieldType.OBJECT_ID )
    private String reviews;
    private String image;

    @Field("value") // Map to the "sales" field in the document
    private Value value; // Object
    private Category category;


    public Product(String id, String name, String brand, String description, Integer totalRating, String reviews, String image, Value value, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.totalRating = totalRating;
        this.reviews = reviews;
        this.image = image;
        this.value = value;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static class Value {
        private double price;
        private double discount;
        private boolean status;

        public Value(double price, double discount, boolean status) {
            this.price = price;
            this.discount = discount;
            this.status = status;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
}