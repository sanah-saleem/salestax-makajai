package com.assignment.SalesTax.Util;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "tax")
@Getter
@Setter
public class TaxProperties {
    private BigDecimal basicRate;
    private BigDecimal importRate;
    private BigDecimal roundingFactor;
}
