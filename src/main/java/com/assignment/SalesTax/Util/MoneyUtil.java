package com.assignment.SalesTax.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoneyUtil {
    
    private static final BigDecimal ROUND_INCREMENT = new BigDecimal("0.05");

    public static BigDecimal roundTax(BigDecimal tax) {
        if(tax.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        BigDecimal divided = tax.divide(ROUND_INCREMENT, 0, RoundingMode.UP);
        return divided.multiply(ROUND_INCREMENT).setScale(2, RoundingMode.UNNECESSARY);
    }

}
