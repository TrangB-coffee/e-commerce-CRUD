package com.example.ecommerce.item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    //void createItem(Item item, String categoryName);
    void createItem(Item item);
    Item getItemById(Long id);


    boolean updateItemById(Long id, Item item);

    boolean deleteItemById(Long id);


}
