package com.uep.wap.repository;

import com.uep.wap.model.Auction;
import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<Auction, Long> {

    Auction findByName(String name);
}
