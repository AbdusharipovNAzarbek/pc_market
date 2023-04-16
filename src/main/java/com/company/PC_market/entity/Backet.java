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
public class Backet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double subtotal;

    private Integer quantity;
    @ManyToMany
    private List<Product> products;

    public Backet(String name, Double subtotal, Integer quantity, List<Product> products) {
        this.name = name;
        this.subtotal = subtotal;
        this.quantity = quantity;
        this.products = products;
    }
}
