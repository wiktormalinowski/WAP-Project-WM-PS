package com.uep.wap.controller;

import com.uep.wap.dto.AuctionDTO;
import com.uep.wap.model.Auction;
import com.uep.wap.service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/auctionController")
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping(path = "/getAuctions")
    public String getAllAuctions(Model model) {
        List<Auction> auctions = new ArrayList<>();

        auctionService.getAllAuctions().forEach(auctions::add);
        model.addAttribute("auctions", auctions);

        return "auctions";
    }

    @PostMapping(path = "/addAuction")
    public String addAuction(AuctionDTO auctionDTO) {
        auctionService.addAuction(auctionDTO);
        return "Auction added!";
    }
}
