package com.company.PC_market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String description;
    @OneToMany
    private List<Product> products;

    public Action(String name, String description, List<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }
}
