package com.example.ecommerce.item;


import com.example.ecommerce.utils.IDGenerator;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name="item_table")
public class Item {
    @Id
    private  Long id;
    private  String title;
    private  String description;
    private  Float price;
    private  Integer quantity;
    private  String location;
    private Long categoryId;

//    @PrePersist
//    protected void onCreate(){
//        this.id = IDGenerator.generateID();
//    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }







    //Need this: for jpa to instance obj
    public Item(){

    }
    public Item(Long id, String title, String description, Float price, Integer quantity, String location,Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
        this.categoryId = categoryId;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }
}
