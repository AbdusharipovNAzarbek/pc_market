package com.company.PC_market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String phone_number;
    private String email;
    private String address;
    @OneToOne
    private Order order;

    public User(String name, String phone_number, String email, String address, Order order) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.order = order;
    }
}
