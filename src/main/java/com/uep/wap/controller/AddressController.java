package com.uep.wap.controller;

import com.uep.wap.dto.AddressDTO;
import com.uep.wap.model.Address;
import com.uep.wap.model.Category;
import com.uep.wap.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/getItems")
    public Iterable<Address> getAllAddresses() {return addressService.getAllAddresses();}

    @PostMapping(path = "/addItem")
    public String addAddress(AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return "Address added!";
    }

}
