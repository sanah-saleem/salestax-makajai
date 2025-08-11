package com.assignment.SalesTax.Tax;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Entity.ProductCategory;
import com.assignment.SalesTax.Util.MoneyUtil;

@Component
public class BasicSalesTaxCalculator implements ITaxCalculator{

    private final BigDecimal rate = new BigDecimal(0.10);

    @Override
    public BigDecimal calculateTax(Product product) {
        if(product.getCategory() == ProductCategory.OTHER) {
            return MoneyUtil.roundTax(product.getPrice().multiply(rate));
        }
        return BigDecimal.ZERO;
    }
    
}
