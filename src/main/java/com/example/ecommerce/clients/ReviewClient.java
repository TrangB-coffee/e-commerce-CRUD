package com.example.ecommerce.clients;

import com.example.ecommerce.item.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> getReview(@RequestParam("itemId") Long itemId);
}
//ResponseEntity<List<Review>> reviewResponse =  restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?itemId=" + item.getId(),
//        HttpMethod.GET,
//        null,
//        new ParameterizedTypeReference<List<Review>>() {
//        });