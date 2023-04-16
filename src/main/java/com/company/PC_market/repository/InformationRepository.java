package com.company.PC_market.repository;

import com.company.PC_market.entity.Information;
import com.company.PC_market.projection.InformationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "information",excerptProjection = InformationProjection.class)
public interface InformationRepository extends JpaRepository<Information,Integer> {
}
