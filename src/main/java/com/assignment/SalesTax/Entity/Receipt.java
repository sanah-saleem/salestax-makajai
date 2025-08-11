package com.assignment.SalesTax.Entity;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Receipt {
    private List<ReceiptLine> lines;
    private BigDecimal totalSalesTax;
    private BigDecimal total;
}
