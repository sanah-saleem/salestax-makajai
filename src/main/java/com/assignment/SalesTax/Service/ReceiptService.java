package com.assignment.SalesTax.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Entity.Receipt;
import com.assignment.SalesTax.Entity.ReceiptLine;
import com.assignment.SalesTax.Tax.BasicSalesTaxCalculator;
import com.assignment.SalesTax.Tax.ImportDutyTaxCalculator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReceiptService {

    private final BasicSalesTaxCalculator basicSalesTaxCalculator;
    private final ImportDutyTaxCalculator importDutyTaxCalculator;

    public Receipt generateReceipt(List<Product> products) {

        List<ReceiptLine> lines = new ArrayList<>();
        BigDecimal totalTaxes = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;

        for(Product product : products) {
            BigDecimal tax = basicSalesTaxCalculator.calculateTax(product)
                    .add(importDutyTaxCalculator.calculateTax(product));
            BigDecimal priceWithTax = product.getPrice().add(tax);
            lines.add(new ReceiptLine(product.getQuantity(), product.getName(), priceWithTax));
            totalTaxes = totalTaxes.add(tax);
            total = total.add(priceWithTax);
        }

        return new Receipt(lines, totalTaxes, total);

    }

}
