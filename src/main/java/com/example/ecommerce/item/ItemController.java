package com.example.ecommerce.item;


import com.example.ecommerce.item.dto.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item item){
        itemService.createItem(item);
        return new ResponseEntity<>("Item add market successfully",HttpStatus.OK);
    }
//    public ResponseEntity<String> createItem(@RequestBody ItemRequest request){
//        itemService.createItem(request.getItem(), request.getCategoryName());
//        return new ResponseEntity<>("Item add market successfully",HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemService.getItemById(id);
        if(item != null){
            return new ResponseEntity<>(item,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable Long id){

        boolean deleted = itemService.deleteItemById(id);
        if(deleted){
            return new ResponseEntity<>("Deleted Item successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //@RequestMapping(value = "/items/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateItemById(@PathVariable Long id,@RequestBody Item item){

        boolean updated = itemService.updateItemById(id,item);
        if(updated){
            return new ResponseEntity<>("Updated Item successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
