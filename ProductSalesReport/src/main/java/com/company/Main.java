package com.company;

public class Main {
    public static void main(String[] args) {
        int[][] productSales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };

        ProductSales sales = new ProductSales();

        int total = sales.TotalSales(productSales);
        double average = sales.AverageSales(productSales);
        int max = sales.MaxSale(productSales);
        int min = sales.MinSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + Math.round(average));
        System.out.println("Maximum sales: " + max);
        System.out.println("Minimum sales: " + min);
        System.out.println("----------------------------------");
    }
}
