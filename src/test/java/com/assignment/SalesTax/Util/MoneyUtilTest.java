package com.assignment.SalesTax.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class MoneyUtilTest {

    @Test
    public void shouldRoundUpToNearestPoint05() {

        TaxProperties props = new TaxProperties();
        props.setRoundingFactor(new BigDecimal("0.05"));
        MoneyUtil util = new MoneyUtil(props);
        
        assertEquals(new BigDecimal("1.25"), util.roundTax(new BigDecimal("1.24")));
        assertEquals(new BigDecimal("1.25"), util.roundTax(new BigDecimal("1.21")));
        assertEquals(new BigDecimal("1.20"), util.roundTax(new BigDecimal("1.20")));
    }
}
