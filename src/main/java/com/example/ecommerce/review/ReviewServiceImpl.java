package com.example.ecommerce.review;

import com.example.ecommerce.item.Item;
import com.example.ecommerce.item.ItemService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final ItemService itemService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ItemService itemService) {
        this.reviewRepository = reviewRepository;
        this.itemService = itemService;
    }

    @Override
    public List<Review> getAllReviews(Long itemId) {
        List<Review> reviews = reviewRepository.findByItemId(itemId);
        return reviews;
    }

    @Override
    public boolean addReview(Long itemId, Review review) {
        Item item = itemService.getItemById(itemId);
        if(item!=null){
            review.setItem(item);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long itemId, Long reviewId, Review review) {
        if(itemService.getItemById(itemId)!=null){
           review.setItem(itemService.getItemById(itemId));
           review.setId(reviewId);
           review.setCreatedAt(new Date());
           reviewRepository.save(review);
           return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long itemId, Long reviewId) {
        if(itemService.getItemById(itemId)!= null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Item item = review.getItem();
            item.getReviews().remove(review);
            review.setItem(null);
            itemService.updateItemById(itemId,item);
            reviewRepository.deleteById(reviewId);
            return true;
        } else {
            return false;
        }

    }
}
