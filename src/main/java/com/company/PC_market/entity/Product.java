package com.company.PC_market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    @ManyToOne
    private Catalog catalog;
    @ManyToOne
    private SSD ssd;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private HDD hdd;
    @ManyToOne
    private RAM ram;
    @ManyToOne
    private Brand brand;

    public Product(String name, Double price, String description, Catalog catalog, SSD ssd, CPU cpu, HDD hdd, RAM ram, Brand brand) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.catalog = catalog;
        this.ssd = ssd;
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.brand = brand;
    }
}
