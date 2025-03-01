package com.example.ecommerce.clients;

import com.example.ecommerce.item.external.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATEGORY-SERVICE")
public interface CategoryClient {
    @GetMapping("/category/{id}")
    Category geCategory(@PathVariable("id") Long id);

}

//ItemDTO properties store in external;
//Category category = restTemplate
//        .getForObject("http://CATEGORY-SERVICE:8081/category/" + item.getCategoryId(), Category.class);