package com.example.simplecurdsystem.basedangular.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    private String productName;

    private String code;

    private String qty;

    private String description;

    private String unitPrice;

    private String unitInStock;

}
