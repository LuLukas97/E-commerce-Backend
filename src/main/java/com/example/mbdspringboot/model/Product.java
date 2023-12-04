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

    private String slug;


    @Field("value") // Map to the "sales" field in the document
    private Value value; // Object
    @Field("bulletedList")
    private BulletedList bulletedList;
    private Category category;

    @Field("images")
    private Images images;
    private Integer quantity;

    public Product(String id, String name, String brand, String description, Integer totalRating, String slug, Value value, BulletedList bulletedList, Category category, Images images, Integer quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.totalRating = totalRating;
        this.slug = slug;
        this.value = value;
        this.bulletedList = bulletedList;
        this.category = category;
        this.images = images;
        this.quantity = quantity;
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

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Value {
        @Field("price")
        private String price;
        private String discount;
        private boolean status;

        public Value(String price, String discount, boolean status) {
            this.price = price;
            this.discount = discount;
            this.status = status;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
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
    public static class Images {
        private String img1;
        private String img2;
        private String img3;
        private String img4;

        public Images(String img1, String img2, String img3, String img4) {
            this.img1 = img1;
            this.img2 = img2;
            this.img3 = img3;
            this.img4 = img4;
        }

        public String getImg1() {
            return img1;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getImg3() {
            return img3;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
        }

        public String getImg4() {
            return img4;
        }

        public void setImg4(String img4) {
            this.img4 = img4;
        }
    }

}

