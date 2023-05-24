package com.uep.wap.service;

import com.uep.wap.dto.ItemDTO;
import com.uep.wap.dto.PaymentMethodDTO;
import com.uep.wap.model.Item;
import com.uep.wap.model.PaymentMethod;
import com.uep.wap.repository.ItemRepository;
import com.uep.wap.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setWeight(itemDTO.getWeight());
        item.setCondition(itemDTO.getCondition());
        item.setBrand_name(itemDTO.getBrand_name());
        item.setName(itemDTO.getName());
        itemRepository.save(item);
        System.out.println("Item added!");
    }

    public Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

}
