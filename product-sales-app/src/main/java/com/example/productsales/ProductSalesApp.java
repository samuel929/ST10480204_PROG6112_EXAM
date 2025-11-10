package com.example.productsales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Swing GUI application that loads product sales data from memory,
 * calculates totals/averages and shows sales over/under a limit.
 *
 * Buttons: Load Product Data, Save Product Data
 * Menu:
 *   File -> Exit
 *   Tools -> Load Product Data, Save Product Data, Clear
 */
public class ProductSalesApp extends JFrame {
    private static final int SALES_LIMIT = 500;

    private final JTextArea outputArea = new JTextArea(15, 50);
    private final JLabel yearsLabel = new JLabel("Years processed: 0");

    public ProductSalesApp() {
        super("Product Sales Processor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area setup
        outputArea.setEditable(true);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Buttons
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");

        loadButton.addActionListener(this::onLoad);
        saveButton.addActionListener(this::onSave);

        // Panel for controls
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(loadButton);
        topPanel.add(saveButton);
        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(yearsLabel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadMenuItem = new JMenuItem("Load Product Data");
        JMenuItem saveMenuItem = new JMenuItem("Save Product Data");
        JMenuItem clearMenuItem = new JMenuItem("Clear");

        loadMenuItem.addActionListener(this::onLoad);
        saveMenuItem.addActionListener(this::onSave);
        clearMenuItem.addActionListener(e -> onClear());

        toolsMenu.add(loadMenuItem);
        toolsMenu.add(saveMenuItem);
        toolsMenu.addSeparator();
        toolsMenu.add(clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    // Load action: loads in-memory data and displays calculations
    private void onLoad(ActionEvent e) {
        // In-memory sales sample as specified:
        // Year 1: Microphone: 300, Speakers: 150, mixing Desk: 700
        // Year 2: Microphone: 250, Speakers: 200, mixing Desk: 600
        int[][] sample = {
                {300, 150, 700},
                {250, 200, 600}
        };

        ProductSales ps = new ProductSales(sample, SALES_LIMIT);
        StringBuilder sb = new StringBuilder();
        sb.append("Product Sales Data\n");
        sb.append("------------------------------\n");
        String[] productNames = {"Microphone", "Speakers", "Mixing Desk"};

        int[][] data = ps.GetProductSales();
        for (int year = 0; year < data.length; year++) {
            sb.append(String.format("Sales for year %d: ", year + 1));
            for (int p = 0; p < data[year].length; p++) {
                sb.append(String.format("%s: %d", productNames[p], data[year][p]));
                if (p < data[year].length - 1) sb.append(", ");
            }
            sb.append("\n");
        }
        sb.append("\n");

        sb.append(String.format("Total Sales: %d\n", ps.GetTotalSales()));
        sb.append(String.format("Average Sales (per product entry): %.2f\n", ps.getAverageSales()));
        sb.append(String.format("Sales over limit (%d): %d\n", SALES_LIMIT, ps.GetSalesOverLimit()));
        sb.append(String.format("Sales under/equal limit (%d): %d\n", SALES_LIMIT, ps.GetSalesUnderLimit()));
        sb.append("\n");

        outputArea.setText(sb.toString());
        yearsLabel.setText("Years processed: " + ps.GetProductsProcessed());
    }

    // Save action: write the text area content to data.txt
    private void onSave(ActionEvent e) {
        String content = outputArea.getText();
        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write(content);
            JOptionPane.showMessageDialog(this, "Data saved to data.txt", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear action: clear text area and years label
    private void onClear() {
        outputArea.setText("");
        yearsLabel.setText("Years processed: 0");
    }

    public static void main(String[] args) {
        // Ensure Swing UI on EDT
        SwingUtilities.invokeLater(() -> {
            ProductSalesApp app = new ProductSalesApp();
            app.setVisible(true);
        });
    }
}
