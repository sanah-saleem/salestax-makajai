package com.assignment.SalesTax.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.SalesTax.Entity.Product;
import com.assignment.SalesTax.Entity.Receipt;
import com.assignment.SalesTax.Service.ReceiptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/receipts")
@RequiredArgsConstructor
public class ReceiptController {
    
    private final ReceiptService receiptService;

    @PostMapping
    public ResponseEntity<Receipt> generateReceipt(@RequestBody List<Product> products) {
        Receipt receipt = receiptService.generateReceipt(products);
        return new ResponseEntity<>(receipt, HttpStatus.OK);
    }

}
