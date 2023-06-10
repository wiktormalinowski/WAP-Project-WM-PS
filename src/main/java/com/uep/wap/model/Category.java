package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "category_name")
    private String category_name;

    // private PARENT CATEGORY?
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Auction> auctions;

    @ManyToOne(fetch = FetchType.EAGER)
    @Nullable
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    @JsonIgnore
    private Set<Category> subCategories = new HashSet<>();
}
