package com.company.PC_market.repository;

import com.company.PC_market.entity.HDD;
import com.company.PC_market.projection.HddProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "hdd", excerptProjection = HddProjection.class)
public interface HddRepository extends JpaRepository<HDD, Integer> {
}
