package com.uep.wap.service;

import com.uep.wap.dto.AddressDTO;
import com.uep.wap.model.Address;
import com.uep.wap.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void addAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setPostal_code(addressDTO.getPostal_code());
        addressRepository.save(address);
        System.out.println("Address added!");
    }

    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
