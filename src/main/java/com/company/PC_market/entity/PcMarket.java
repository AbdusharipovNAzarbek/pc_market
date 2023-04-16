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
public class PcMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany
    private List<Information> information;
    @OneToMany
    private List<Backet> backets;
    @OneToMany
    private List<Currency> currencies;
    @OneToMany
    private List<Catalog> catalogs;
    @OneToMany
    private List<Blog> blogs;
    @OneToMany
    private List<Action> actions;
    @OneToOne
    private Contact contact;

    public PcMarket(String name, List<Information> information, List<Backet> backets,
                    List<Currency> currencies, List<Catalog> catalogs, List<Blog> blogs,
                    List<Action> actions, Contact contact) {
        this.name = name;
        this.information = information;
        this.backets = backets;
        this.currencies = currencies;
        this.catalogs = catalogs;
        this.blogs = blogs;
        this.actions = actions;
        this.contact = contact;
    }
}
