package com.example.mbdspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document("product")
public class Product {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String brand;

    @Field("sales") // Map to the "sales" field in the document
    private Sale sale;


    public Product(String id, String name, Sale sale, String brand) {
        this.id = id;
        this.name = name;
        this.sale = sale;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public static class Sale {
        private double price;
        private double discount;
        private boolean status;

        public Sale(double price, double discount, boolean status) {
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

        // Getters and setters for price, discount, and status
    }
}