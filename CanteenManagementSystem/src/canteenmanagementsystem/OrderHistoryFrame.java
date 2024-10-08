package canteenmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryFrame extends JFrame {
    private List<String[]> orderHistory;
    private JTable orderTable;
    private JLabel totalCostLabel;
    private double totalOrderCost;

    public OrderHistoryFrame() {
        orderHistory = new ArrayList<>();

        setTitle("Order History");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel historyLabel = new JLabel("Order History:");
        historyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(historyLabel, BorderLayout.NORTH);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Items");
        model.addColumn("Total Quantity");
        model.addColumn("Total Cost");
        model.addColumn("Time");

        orderTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        add(scrollPane, BorderLayout.CENTER);

        totalCostLabel = new JLabel("Total Order Cost: 0.0");
        totalCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalCostLabel, BorderLayout.SOUTH);

        loadOrderHistory();
        populateTable();
        updateTotalOrderCost();

        setVisible(true);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        for (String[] order : orderHistory) {
            model.addRow(order);
        }
    }

    private void updateTotalOrderCost() {
        totalOrderCost = 0;
        for (String[] order : orderHistory) {
            totalOrderCost += Double.parseDouble(order[2]);
        }
        totalCostLabel.setText("Total Order Cost: " + totalOrderCost);
    }

    public static void addOrder(List<StockItem> orderDetails, double totalCost) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);

        StringBuilder items = new StringBuilder();
        int totalQuantity = 0;

        for (StockItem item : orderDetails) {
            items.append(item.getName())
                 .append(" (Qty: ")
                 .append(item.getOrderQuantity())
                 .append(", Unit Price: ")
                 .append(item.getPrice())
                 .append("); ");
            totalQuantity += item.getOrderQuantity();
        }

        if (items.length() > 0) {
            items.setLength(items.length() - 2);
        }

        String[] order = new String[4];
        order[0] = items.toString();
        order[1] = String.valueOf(totalQuantity);
        order[2] = String.valueOf(totalCost);
        order[3] = time;

        List<String[]> tempOrderHistory = new ArrayList<>();
        tempOrderHistory.add(order);

        saveOrderHistory(tempOrderHistory);
    }

    private static void saveOrderHistory(List<String[]> tempOrderHistory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orderHistory.txt", true))) {
            for (String[] order : tempOrderHistory) {
                writer.write(String.join("|||", order));
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadOrderHistory() {
        orderHistory.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("orderHistory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderHistory.add(line.split("\\|\\|\\|"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
