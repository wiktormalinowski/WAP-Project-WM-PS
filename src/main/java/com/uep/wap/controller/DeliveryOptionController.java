package com.uep.wap.controller;

import com.uep.wap.dto.DeliveryOptionDTO;
import com.uep.wap.model.DeliveryOption;
import com.uep.wap.service.DeliveryOptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/deliveryOptionController")
public class DeliveryOptionController {

    private final DeliveryOptionService deliveryOptionService;

    public DeliveryOptionController(DeliveryOptionService deliveryOptionService) {this.deliveryOptionService = deliveryOptionService;}

    @GetMapping(path = "/getDeliveryOptions")
    public Iterable<DeliveryOption> getAllDeliveryOptions() { return deliveryOptionService.getAllDeliveryOptions();}

    @PostMapping(path = "/addDeliveryOption")
    public String addDeliveryOption(@RequestBody DeliveryOptionDTO deliveryOptionDTO){
        deliveryOptionService.addDeliveryOption(deliveryOptionDTO);
        return "Delivery Option added!";
    }

}
