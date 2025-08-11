package com.assignment.SalesTax.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private String name;
    private BigDecimal price;
    private boolean imported;
    private ProductCategory category;
    private int quantity;
}
