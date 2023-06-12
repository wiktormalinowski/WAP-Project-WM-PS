package com.uep.wap.service;

import com.uep.wap.dto.BidDTO;
import com.uep.wap.model.Bid;
import com.uep.wap.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public void addBid(BidDTO bidDTO){
        Bid bid = new Bid();
        bid.setBid_amount(bidDTO.getBid_amount());
        bidRepository.save(bid);
        System.out.println("Bid applied!");
    }


    public Iterable<Bid> getAllBids() {
        return bidRepository.findAll();
    }
}
