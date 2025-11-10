package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    int[][] productSales = {
        {300, 150, 700}, // Year 1
        {250, 200, 600}  // Year 2
    };

    ProductSales sales = new ProductSales();

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        int expected = 2200;
        int actual = sales.TotalSales(productSales);
        assertEquals(expected, actual, "Total sales calculation is incorrect");
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        double expected = 2200.0 / 6.0;
        double actual = sales.AverageSales(productSales);
        assertEquals(expected, actual, 0.01, "Average sales calculation is incorrect");
    }

    @Test
    public void MaxSale_ReturnsMaximumValue() {
        int expected = 700;
        int actual = sales.MaxSale(productSales);
        assertEquals(expected, actual);
    }

    @Test
    public void MinSale_ReturnsMinimumValue() {
        int expected = 150;
        int actual = sales.MinSale(productSales);
        assertEquals(expected, actual);
    }
}
