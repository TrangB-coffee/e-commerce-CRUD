package com.example.ecommerce.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items/{itemId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long itemId){
        return new ResponseEntity<>(reviewService.getAllReviews(itemId), HttpStatus.OK);

    }

    @PostMapping("/reviews")
    public  ResponseEntity<String> addReview(@PathVariable Long itemId, @RequestBody Review review){
        boolean isReviewed = reviewService.addReview(itemId,review);
        if(isReviewed){
            return new ResponseEntity<>("Add review successfully",HttpStatus.OK);
        } else return new ResponseEntity<>("Review is not saved",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long itemId, @PathVariable Long reviewId,@RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(itemId,reviewId,review);
        if(isUpdated){
            return new ResponseEntity<>("Update review successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot update review.",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long itemId, @PathVariable Long reviewId){
        boolean isUpdated = reviewService.deleteReview(itemId,reviewId);
        if(isUpdated){
            return new ResponseEntity<>("Delete review successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot delete review.",HttpStatus.NOT_FOUND);
    }
}
