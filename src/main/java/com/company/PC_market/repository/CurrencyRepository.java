package com.company.PC_market.repository;

import com.company.PC_market.entity.Currency;
import com.company.PC_market.projection.CurrencyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency",excerptProjection = CurrencyProjection.class)
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
