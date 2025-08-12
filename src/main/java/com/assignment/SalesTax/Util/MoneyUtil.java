package com.assignment.SalesTax.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MoneyUtil {
    
    private final TaxProperties taxProperties;

    public BigDecimal roundTax(BigDecimal tax) {

        BigDecimal ROUND_INCREMENT = taxProperties.getRoundingFactor();

        if(tax.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        BigDecimal divided = tax.divide(ROUND_INCREMENT, 0, RoundingMode.UP);

        return divided.multiply(ROUND_INCREMENT).setScale(2, RoundingMode.UNNECESSARY);

    }

}
