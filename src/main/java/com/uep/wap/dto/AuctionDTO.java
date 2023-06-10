package com.uep.wap.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuctionDTO {
    private String name;
    private int quantity;
    private float start_price;
    private float min_bid;
    private float buy_now_price;
    private LocalDate end_date;
    private AddressDTO addressDTO;
    private ItemDTO itemDTO;
    private CategoryDTO categoryDTO;
    private PaymentMethodDTO paymentMethodDTO;
    private DeliveryOptionDTO deliveryOptionDTO;
    private UserDTO userDTO;
}
