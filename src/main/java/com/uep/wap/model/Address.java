package com.uep.wap.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postal_code;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Auction> auctions;

}
