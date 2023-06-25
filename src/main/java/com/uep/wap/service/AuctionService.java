package com.uep.wap.service;

import com.uep.wap.dto.AuctionDTO;
import com.uep.wap.model.Auction;
import com.uep.wap.model.Item;
import com.uep.wap.repository.AuctionRepository;
import com.uep.wap.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void addAuction(AuctionDTO auctionDTO) {
        Item item = new Item();
        item.setName(auctionDTO.getItem().getName());
        item.setCondition(auctionDTO.getItem().getCondition());
        itemRepository.save(item);

        Auction auction = new Auction();
        auction.setName(auctionDTO.getName());
        auction.setQuantity(auctionDTO.getQuantity());
        auction.setCurrent_bid_price(auctionDTO.getStart_price());
        auction.setStart_price(auctionDTO.getStart_price());
        auction.setMin_bid(auctionDTO.getMin_bid());
        auction.setBuy_now_price(auctionDTO.getBuy_now_price());
        auction.setEnd_date(auctionDTO.getEnd_date());
        auction.setItem(item);

        auctionRepository.save(auction);
        System.out.println("Auction added!");
    }

    public Iterable<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(long id) {
        return auctionRepository.findById(id).get();
    }

    public Auction getAuctionByName(String name) {
        return auctionRepository.findByName(name);
    }
}
