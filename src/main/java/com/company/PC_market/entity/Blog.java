package com.company.PC_market.entity;

import com.company.PC_market.entity.base_entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog extends BaseEntity {
    private String description;
}
