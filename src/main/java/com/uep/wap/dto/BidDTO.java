package com.uep.wap.dto;

import com.uep.wap.model.Auction;
import com.uep.wap.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidDTO {
    private Float bid_amount;
    private User user;
    private Auction auction;
}
