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
    private String slug;


    @Field("value") // Map to the "sales" field in the document
    private Value value; // Object
    @Field("bulletedList")
    private BulletedList bulletedList;
    private Category category;

    public Product(String id, String name, String brand, String description, Integer totalRating, String reviews, String image, String slug, Value value, BulletedList bulletedList, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.totalRating = totalRating;
        this.reviews = reviews;
        this.image = image;
        this.slug = slug;
        this.value = value;
        this.bulletedList = bulletedList;
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public BulletedList getBulletedList() {
        return bulletedList;
    }

    public void setBulletedList(BulletedList bulletedList) {
        this.bulletedList = bulletedList;
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

    public static class BulletedList {
        private String list1;
        private String list2;
        private String list3;

        public BulletedList(String list1, String list2, String list3) {
            this.list1 = list1;
            this.list2 = list2;
            this.list3 = list3;
        }

        public String getList1() {
            return list1;
        }

        public void setList1(String list1) {
            this.list1 = list1;
        }

        public String getList2() {
            return list2;
        }

        public void setList2(String list2) {
            this.list2 = list2;
        }

        public String getList3() {
            return list3;
        }

        public void setList3(String list3) {
            this.list3 = list3;
        }
    }

}

