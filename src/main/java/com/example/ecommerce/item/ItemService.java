package com.example.ecommerce.item;

import com.example.ecommerce.item.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> findAll();
    //void createItem(Item item, String categoryName);
    void createItem(Item item);
    Item getItemById(Long id);


    boolean updateItemById(Long id, Item item);

    boolean deleteItemById(Long id);


}
