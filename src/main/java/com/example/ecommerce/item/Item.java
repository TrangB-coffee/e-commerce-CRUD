package com.example.ecommerce.item;

import com.example.ecommerce.category.Category;
import com.example.ecommerce.review.Review;
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
    private  Integer quanity;
    private  String location;

    @PrePersist
    protected void onCreate(){
        this.id = IDGenerator.generateID();
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "item")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //Need this: for jpa to instance obj
    public Item(){

    }
    public Item(Long id, String title, String description, Float price, Integer quanity, String location, Category category, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quanity = quanity;
        this.location = location;
        this.category = category;
        this.reviews = reviews;
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

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
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

    public Integer getQuanity() {
        return quanity;
    }

    public String getLocation() {
        return location;
    }
}
