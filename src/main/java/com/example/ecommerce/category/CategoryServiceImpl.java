package com.example.ecommerce.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean updateCategory(Category category, Long id) {
        Optional<Category> tagOptional = categoryRepository.findById(id);

        if(tagOptional.isPresent()){
            Category tag = tagOptional.get();
            tag.setName(category.getName());
            tag.setDescription(category.getDescription());
            categoryRepository.save(tag);
            return true;
        }

        return false;
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean deletedCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
