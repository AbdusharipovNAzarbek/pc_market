package com.company.PC_market.repository;

import com.company.PC_market.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    boolean existsByName(String name);
}
