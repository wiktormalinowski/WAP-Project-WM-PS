package com.uep.wap.controller;

import com.uep.wap.dto.AuctionDTO;
import com.uep.wap.dto.BidDTO;
import com.uep.wap.model.Auction;
import com.uep.wap.model.Bid;
import com.uep.wap.service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "allAuctions";
    }

    @GetMapping(path = "/auction{id}")
    public String getAuctionById(Model model, @RequestParam long id) {

        Auction auction = auctionService.getAuctionById(id);
        model.addAttribute("auction", auction);
        model.addAttribute("newBid", new BidDTO());

        return "auction";
    }

    @PostMapping(path = "/newAuction")
    public String addAuction(@ModelAttribute AuctionDTO auctionDTO) {

        if ( auctionService.getAuctionByName( auctionDTO.getName()) != null ) {
            return "redirect:/userController/newAuction";
        }
        auctionService.addAuction(auctionDTO);
        return "redirect:/auctionController/getAuctions";
    }

    @GetMapping(path = "/newAuction")
    public String addAuctionForm(Model model) {
        model.addAttribute("auction", new Auction());
        return "newAuction";
    }
}
