package com.company.PC_market.repository;

import com.company.PC_market.entity.Contact;
import com.company.PC_market.projection.ContactProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "contact",excerptProjection = ContactProjection.class)
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
