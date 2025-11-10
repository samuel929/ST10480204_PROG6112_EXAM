package com.example.productsales;

/**
 * ProductSales implements IProductSales.
 * The sales data is represented as rows = years, cols = products.
 * Product ordering: 0 = Microphone, 1 = Speakers, 2 = Mixing Desk
 */
public class ProductSales implements IProductSales {
    private final int[][] sales; // [year][product]
    private final int salesLimit;

    public ProductSales(int[][] sales, int salesLimit) {
        if (sales == null) throw new IllegalArgumentException("sales cannot be null");
        this.sales = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) {
            this.sales[i] = sales[i].clone();
        }
        this.salesLimit = salesLimit;
    }

    @Override
    public int[][] GetProductSales() {
        int[][] copy = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) copy[i] = sales[i].clone();
        return copy;
    }

    @Override
    public int GetTotalSales() {
        int sum = 0;
        for (int[] year : sales) {
            for (int v : year) sum += v;
        }
        return sum;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int v : year) {
                if (v > salesLimit) count++;
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int v : year) {
                if (v <= salesLimit) count++;
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return sales.length; // number of years processed
    }

    @Override
    public double getAverageSales() {
        int totalEntries = 0;
        int sum = 0;
        for (int[] year : sales) {
            totalEntries += year.length;
            for (int v : year) sum += v;
        }
        if (totalEntries == 0) return 0.0;
        return (double) sum / totalEntries;
    }
}
