package com.uep.wap.controller;

import com.uep.wap.MyUserPrincipal;
import com.uep.wap.dto.BidDTO;
import com.uep.wap.model.Auction;
import com.uep.wap.model.Bid;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import com.uep.wap.service.AuctionService;
import com.uep.wap.service.BidService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/bidController")
public class BidController {

    private final BidService bidService;
    private final UserRepository userRepository;
    private final AuctionService auctionService;

    public BidController(BidService bidService,
                         UserRepository userRepository,
                         AuctionService auctionService)
    {
        this.bidService = bidService;
        this.userRepository = userRepository;
        this.auctionService = auctionService;
    }

    @GetMapping(path = "/getBids")
    public Iterable<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @PostMapping(path = "/addBid")
    public String addBid(@RequestParam("id") Long id,
                         @AuthenticationPrincipal MyUserPrincipal userDetails,
                         @ModelAttribute BidDTO bid,
                         RedirectAttributes redirectAttributes)
    {
        User user = userRepository.findByUsername(userDetails.getUsername());
        Auction auction = auctionService.getAuctionById(id);
        auction.setCurrent_bid_price(auction.getCurrent_bid_price() + bid.getBid_amount());
        bid.setUser(user);
        bid.setAuction(auctionService.getAuctionById(id));
        bidService.addBid(bid);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/auctionController/auction";
    }
}
