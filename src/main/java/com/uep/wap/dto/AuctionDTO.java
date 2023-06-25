package com.uep.wap.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class AuctionDTO {
    private ItemDTO item;
    private String name;
    private int quantity;
    private float start_price;
    private float min_bid;
    private float buy_now_price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_date;
    private AddressDTO address;
    private CategoryDTO category;
    private PaymentMethodDTO paymentMethod;
    private DeliveryOptionDTO deliveryOption;
    private UserDTO user;
}
