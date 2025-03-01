package com.example.ecommerce.item.external;

public class Review {
    private Long id;
    private Double rating;
    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public Review(Long id, Double rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;

    }
}
