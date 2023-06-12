package com.uep.wap.controller;

import com.uep.wap.dto.BidDTO;
import com.uep.wap.model.Bid;
import com.uep.wap.service.BidService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bidController")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {this.bidService = bidService;}

    @GetMapping(path = "/getBids")
    public Iterable<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @PostMapping(path = "/addBid")
    public String addBid(@RequestBody BidDTO bidDTO){
        bidService.addBid(bidDTO);
        return "Bid applied!";
    }




}
