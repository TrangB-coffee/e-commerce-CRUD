package com.ecommerce.review.review;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long itemId) {
        List<Review> reviews = reviewRepository.findByItemId(itemId);
        return reviews;
    }

    @Override
    public boolean addReview(Long itemId,Review review) {

        if(itemId!=null){
            review.setItemId(itemId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review!=null){
            updatedReview.setComment(updatedReview.getComment());
            updatedReview.setRating(updatedReview.getRating());
            updatedReview.setCreatedAt(new Date());
           reviewRepository.save(updatedReview);
           return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review!=null){
            reviewRepository.delete(review);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
}
