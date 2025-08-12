package com.assignment.SalesTax.Tax;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Entity.ProductCategory;
import com.assignment.SalesTax.Util.MoneyUtil;
import com.assignment.SalesTax.Util.TaxProperties;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BasicSalesTaxCalculator implements ITaxCalculator{

    private final TaxProperties taxProperties;
    private final MoneyUtil moneyUtil;

    @Override
    public BigDecimal calculateTax(Product product) {

        BigDecimal rate = taxProperties.getBasicRate();

        if(product.getCategory() == ProductCategory.OTHER) {
            return moneyUtil.roundTax(product.getPrice().multiply(rate));
        }
        return BigDecimal.ZERO;
    }
    
}
