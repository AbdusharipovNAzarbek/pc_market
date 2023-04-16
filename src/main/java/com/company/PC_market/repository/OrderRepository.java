package com.company.PC_market.repository;

import com.company.PC_market.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    boolean existsByName(String name);
}
