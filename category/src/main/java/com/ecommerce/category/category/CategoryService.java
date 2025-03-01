package com.ecommerce.category.category;

import java.util.List;


public interface CategoryService {
    List<Category> getAllCategory();
    boolean updateCategory(Category category,Long id);
    void createCategory(Category category);

    boolean deletedCategory(Long id);



    Category getCategoryById(Long id);
}
