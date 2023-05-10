package com.uep.wap.service;

import com.uep.wap.dto.DeliveryOptionDTO;
import com.uep.wap.model.DeliveryOption;
import com.uep.wap.repository.DeliveryOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOptionService {

    @Autowired
    private DeliveryOptionRepository deliveryOptionRepository;

    public void addDeliveryOption(DeliveryOptionDTO deliveryOptionDTO){
        DeliveryOption deliveryOption = new DeliveryOption();
        deliveryOption.setDelivery_company(deliveryOptionDTO.getDelivery_company());
        deliveryOption.setDelivery_price(deliveryOptionDTO.getDelivery_price());
        deliveryOption.setDescription(deliveryOptionDTO.getDescription());
        deliveryOptionRepository.save(deliveryOption);
        System.out.println("Delivery Option added!");
    }



}
