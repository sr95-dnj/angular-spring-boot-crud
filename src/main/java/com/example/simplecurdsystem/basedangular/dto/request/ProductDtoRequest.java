package com.example.simplecurdsystem.basedangular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRequest {

    private String productName;

    private String code;

    private String qty;

    private String description;

    private String unitPrice;

    private String unitInStock;

}
