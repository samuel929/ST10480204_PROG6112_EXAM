package com.example.productsales;

/**
 * Interface for ProductSales operations.
 */
public interface IProductSales {
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
    double getAverageSales();
}
