package com.example.ecommerce.DTO;

import com.example.ecommerce.category.Category;
import com.example.ecommerce.item.Item;
import com.example.ecommerce.review.Review;

import java.util.List;

public class ItemRequest {
    private String categoryName;
    private Item item;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemRequest(String categoryName, Item item) {
        this.categoryName = categoryName;
        this.item = item;
    }
}
