package com.example.ecommerce.mapper;

import com.example.ecommerce.item.Item;
import com.example.ecommerce.item.dto.ItemDTO;
import com.example.ecommerce.item.external.Category;
import com.example.ecommerce.item.external.Review;

import java.util.List;

public class CategoryMapper {
    public static ItemDTO mapToItemDto(Category category, Item item, List<Review> review) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setTitle(item.getTitle());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setLocation(item.getLocation());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setQuantity(item.getQuantity());
        itemDTO.setCategory(category);
        itemDTO.setReview(review);
        return itemDTO;
    }
}
