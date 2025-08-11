package com.assignment.SalesTax.Tax;

import java.math.BigDecimal;

import com.assignment.SalesTax.Entity.Product;

public interface ITaxCalculator {
    BigDecimal calculateTax(Product product);
}
