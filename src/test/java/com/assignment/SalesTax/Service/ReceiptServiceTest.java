package com.assignment.SalesTax.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Entity.ProductCategory;
import com.assignment.SalesTax.Entity.Receipt;
import com.assignment.SalesTax.Tax.BasicSalesTaxCalculator;
import com.assignment.SalesTax.Tax.ImportDutyTaxCalculator;

public class ReceiptServiceTest {
    
    private ReceiptService receiptService;

    @BeforeEach
    void setup() {
        receiptService = new ReceiptService(
            new BasicSalesTaxCalculator(),
            new ImportDutyTaxCalculator()
            );
    }

    @Test
    void shouldCalculateExampleInput1() {

        List<Product> products = List.of(
            new Product("book", new BigDecimal("12.49"), false, ProductCategory.BOOK, 1),
            new Product("music CD", new BigDecimal("14.99"), false, ProductCategory.OTHER, 1),
            new Product("Chocolate bar", new BigDecimal("0.85"), false, ProductCategory.FOOD, 1)
        );
        
        Receipt receipt = receiptService.generateReceipt(products);

        assertTrue(receipt.getTotalSalesTax().compareTo(new BigDecimal("1.50")) == 0);
        assertTrue(receipt.getTotal().compareTo(new BigDecimal("29.83")) == 0);
        assertEquals(3, receipt.getLines().size());

    }

    @Test
    void shouldCalculateExampleInput2() {

        List<Product> products = List.of(
            new Product("imported chocolate bar", new BigDecimal("10.00"), true, ProductCategory.FOOD, 1),
            new Product("imported perfume bottle", new BigDecimal("47.50"), true, ProductCategory.OTHER, 1)
        );

        Receipt receipt = receiptService.generateReceipt(products);

        assertTrue(receipt.getTotalSalesTax().compareTo(new BigDecimal("7.70")) == 0);
        assertTrue(receipt.getTotal().compareTo(new BigDecimal("65.20")) == 0);

    }

}
