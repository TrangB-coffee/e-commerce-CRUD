package com.ecommerce.review.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long itemId);

    boolean addReview(Long itemId, Review review);

    boolean updateReview( Long reviewId, Review review);

    boolean deleteReview(Long reviewId);

    Review getReview(Long reviewId);
}
