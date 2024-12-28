package com.example.ecommerce.item;

import com.example.ecommerce.category.Category;
import com.example.ecommerce.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    //private List<Item> items = new ArrayList<Item>();

    private ItemRepository itemRepository;



    //private CategoryRepository categoryRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    public ItemServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
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
                item.setQuanity(updateItem.getQuanity());
                item.setLocation(updateItem.getLocation());
                itemRepository.save(item);
                return true;
            }


        return false;
    }

}
