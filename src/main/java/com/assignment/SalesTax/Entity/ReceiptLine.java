package com.assignment.SalesTax.Entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReceiptLine {
    private int quantity;
    private String description;
    private BigDecimal priceWithTax;

    @Override
    public String toString() {
        return quantity + " " + description + " " + priceWithTax; 
    }
}
