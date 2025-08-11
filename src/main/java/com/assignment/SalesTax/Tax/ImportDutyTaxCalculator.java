package com.assignment.SalesTax.Tax;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Util.MoneyUtil;

@Component
public class ImportDutyTaxCalculator implements ITaxCalculator{
    
    private final BigDecimal rate = new BigDecimal("0.05");

    @Override
    public BigDecimal calculateTax(Product product) {
        if(product.isImported()) {
            return MoneyUtil.roundTax(product.getPrice().multiply(rate));
        }
        return BigDecimal.ZERO;
    }



}
