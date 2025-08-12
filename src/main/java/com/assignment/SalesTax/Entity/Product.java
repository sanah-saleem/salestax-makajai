package com.assignment.SalesTax.Entity;

import static com.assignment.SalesTax.Exception.ErrorMessages.*;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {

    @NotBlank(message = PRODUCT_NAME_IS_MANDATORY)
    private String name;

    @NotNull(message = PRICE_CANNOT_BE_NULL)
    @DecimalMin(value = MIN_PRICE_VALUE, message=PRICE_MUST_BE_GREATER_THAN_ZERO)
    private BigDecimal price;

    private boolean imported;

    @NotNull(message = PRODUCT_CATEGORY_REQUITRED)
    private ProductCategory category;

    @Min(value = 1, message = QUANTITY_MUST_BE_ATLEAST_1)
    private int quantity;
}
