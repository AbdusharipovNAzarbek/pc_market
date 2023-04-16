package com.company.PC_market.repository;

import com.company.PC_market.entity.Catalog;
import com.company.PC_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByNameAndCatalogId(String name, Integer catalog_id);
}
