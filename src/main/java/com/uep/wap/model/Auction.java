package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "auctions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "current_bid_price")
    private float current_bid_price;

    @Column(name = "start_price")
    private float start_price;

    @Column(name = "min_bid")
    private float min_bid;

    @Column(name = "buy_now_price")
    @Nullable
    private float buy_now_price;

    @Column(name = "status")
    private String status;

    //this property is not in the figma diagram, but it is very important for the auction to work
    @Column(name = "end_date")
    private LocalDate end_date;

    //Foreign keys below

    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryOption deliveryOption;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bid> bidList;
}
