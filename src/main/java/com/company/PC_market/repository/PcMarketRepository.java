package com.company.PC_market.repository;

import com.company.PC_market.entity.PcMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcMarketRepository extends JpaRepository <PcMarket,Integer>{

    boolean existsByName(String name);
}
