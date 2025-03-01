package com.ecommerce.review.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double rating;
    private String comment;
    private Long itemId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Review(Long id, Double rating, String comment, Long itemId, Date createdAt) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.itemId = itemId;
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.DATE)
    private Date createdAt;



    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }

    public  Review(){

    }


    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
