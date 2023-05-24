package com.uep.wap.controller;

import com.uep.wap.service.ItemService;
import com.uep.wap.model.Item;
import com.uep.wap.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/item")
public class ItemController {

    private final ItemService itemService;

public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/items")
    public Iterable<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @PostMapping(path = "/items")
    public String addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return "Item added!";
    }

}
