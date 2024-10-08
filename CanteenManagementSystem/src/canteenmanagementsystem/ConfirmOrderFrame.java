package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConfirmOrderFrame extends JFrame {
    private List<StockItem> orderDetails;
    private double totalCost;

    public ConfirmOrderFrame(List<StockItem> orderDetails, double totalCost) {
        this.orderDetails = orderDetails;
        this.totalCost = totalCost;
        setTitle("Confirm Order");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel confirmLabel = new JLabel("Confirm Order:");
        confirmLabel.setBounds(350, 20, 200, 25);
        add(confirmLabel);

        JTextArea orderSummary = new JTextArea();
        orderSummary.setBounds(350, 50, 350, 150);
        StringBuilder summary = new StringBuilder();
        for (StockItem item : orderDetails) {
            summary.append(item.getName()).append(": ").append(item.getOrderQuantity()).append("\n");
        }
        summary.append("\nTotal Cost: ").append(totalCost);
        orderSummary.setText(summary.toString());
        orderSummary.setEditable(false);
        add(orderSummary);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(480, 220, 100, 30);
        add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderHistoryFrame.addOrder(orderDetails, totalCost);
                OrderHistoryFrame orderHistoryFrame = new OrderHistoryFrame();
                orderHistoryFrame.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}
