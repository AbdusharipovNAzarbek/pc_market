package com.company.PC_market.repository;

import com.company.PC_market.entity.Backet;
import com.company.PC_market.service.BacketService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacketRepository extends JpaRepository<Backet, Integer> {
    boolean existsByName(String name);
}
