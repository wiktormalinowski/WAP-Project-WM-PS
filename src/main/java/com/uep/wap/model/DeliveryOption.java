package com.uep.wap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "delivery_options")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeliveryOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="delivery_company")
    private String delivery_company;

    @Column(name="delivery_price")
    private float delivery_price;

    @Column(name="description")
    private String description;
}
