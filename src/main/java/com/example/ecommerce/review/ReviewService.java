package com.example.ecommerce.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long itemId);

    boolean addReview(Long itemId, Review review);

    boolean updateReview(Long itemId, Long reviewId, Review review);

    boolean deleteReview(Long itemId, Long reviewId);
}
