package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "method_name")
    private String method_name;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Auction> auctions;
}
