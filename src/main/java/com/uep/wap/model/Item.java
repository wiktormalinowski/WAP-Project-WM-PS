package com.uep.wap.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "item_condition")
    private String condition;

    @Column(name = "weight")
    private float weight;

    @Column(name = "brand_name")
    private String brand_name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Auction> auctions;

}
