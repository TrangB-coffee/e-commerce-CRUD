package com.example.ecommerce.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id,@RequestBody Category category){
        boolean updated = categoryService.updateCategory(category,id);
        if(updated){
            return new ResponseEntity<>("Updated Category successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public  ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletedCategory(@PathVariable Long id){
        boolean deleted = categoryService.deletedCategory(id);
        if(deleted){
            return new ResponseEntity<>("Deleted Category successfully", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("Category not found.", HttpStatus.NOT_FOUND);
        }
    }
}
