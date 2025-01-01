package com.example.ecommerce.item;


import com.example.ecommerce.item.dto.ItemDTO;
import com.example.ecommerce.item.external.Category;
import com.example.ecommerce.item.external.Review;
import com.example.ecommerce.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    //private List<Item> items = new ArrayList<Item>();

    ItemRepository itemRepository;

    //RestTemplate restTemplate = new RestTemplate() store in AppConfig
    @Autowired
    RestTemplate restTemplate;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    public ItemServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @Override
    public List<ItemDTO> findAll() {
        List<Item> items = itemRepository.findAll();
        //List<ItemDTO> itemConnectCategories = new ArrayList<>();

        return items.stream().map(this::convertToDTO).collect(Collectors.toList());

    }
    private ItemDTO convertToDTO(Item item){

            //ItemDTO properties store in external;
            Category category = restTemplate.getForObject("http://CATEGORY-SERVICE:8081/category/" + item.getCategoryId(), Category.class);

            ResponseEntity<List<Review>> reviewResponse =  restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?itemId=" + item.getId(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Review>>() {
                    });
            List<Review> reviews = reviewResponse.getBody();
            ItemDTO itemDTO = CategoryMapper.mapToItemDto(category,item,reviews);
            //itemDTO.setCategory(category);
           return itemDTO;

    }

    @Override
    public void createItem(Item item) {
        itemRepository.save(item);
    }

//    @Override
//    public void createItem(Item item, String categoryName) {
//        Category category = categoryRepository.findByName(categoryName)
//                        .orElseGet(() ->  {
//                                //Create new category if not found
//                                Category newCategory = new Category(categoryName);
//                            return categoryRepository.save(newCategory);
//                        });
//        //Update category name if changed
//        if(!category.getName().equals(categoryName)){
//            category.setName(categoryName);
//            categoryRepository.save(category);
//        }
//
//        //Set the category for item
//        item.setCategory(category);
//        itemRepository.save(item);
//    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteItemById(Long id) {
        try {
            itemRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }


    }


    @Override
    public boolean updateItemById(Long id, Item updateItem) {
        Optional<Item> itemOptional = itemRepository.findById(id);

            if(itemOptional.isPresent()){
                Item item = itemOptional.get();
                item.setTitle(updateItem.getTitle());
                item.setDescription(updateItem.getDescription());
                item.setPrice(updateItem.getPrice());
                item.setQuantity(updateItem.getQuantity());
                item.setLocation(updateItem.getLocation());
                itemRepository.save(item);
                return true;
            }


        return false;
    }

}
