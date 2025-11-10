package com.example.productsales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for ProductSales methods GetSalesOverLimit and GetSalesUnderLimit.
 */
public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        int[][] sample = {
                {300, 150, 700}, // 1 over (700)
                {250, 200, 600}  // 1 over (600)
        };
        ProductSales ps = new ProductSales(sample, 500);
        int over = ps.GetSalesOverLimit();
        Assertions.assertEquals(2, over, "There should be 2 sales over the limit (700 and 600).");
    }

    @Test
    public void GetSalesUnderLimit_ReturnNumbersOfSales() {
        int[][] sample = {
                {300, 150, 700}, // 2 under/equal (300,150)
                {250, 200, 600}  // 2 under/equal (250,200)
        };
        ProductSales ps = new ProductSales(sample, 500);
        int under = ps.GetSalesUnderLimit();
        Assertions.assertEquals(4, under, "There should be 4 sales under or equal to the limit.");
    }
}
