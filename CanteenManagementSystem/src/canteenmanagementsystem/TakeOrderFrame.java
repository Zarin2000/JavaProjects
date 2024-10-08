package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TakeOrderFrame extends JFrame {
    private List<StockItem> stock;
    private List<JCheckBox> itemCheckboxes;
    private List<JTextField> quantityFields;
    private JLabel totalCostLabel;
    private double totalCost;

    public TakeOrderFrame() {
        setTitle("Take Order");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        stock = new ArrayList<>();
        itemCheckboxes = new ArrayList<>();
        quantityFields = new ArrayList<>();

        loadStock();

        int yPosition = 20;

        for (StockItem item : stock) {
            JCheckBox checkBox = new JCheckBox(item.getName());
            checkBox.setBounds(300, yPosition, 150, 25);
            JLabel priceLabel = new JLabel("Price: " + item.getPrice());
            priceLabel.setBounds(460, yPosition, 100, 25);
            JTextField quantityField = new JTextField("0");
            quantityField.setBounds(580, yPosition, 50, 25);

            checkBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        quantityField.setText("1");
                    } else {
                        quantityField.setText("0");
                    }
                    updateTotalCost();
                }
            });

            quantityField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateTotalCost();
                }
            });

            add(checkBox);
            add(priceLabel);
            add(quantityField);

            itemCheckboxes.add(checkBox);
            quantityFields.add(quantityField);

            yPosition += 30;
        }

        totalCostLabel = new JLabel("Total Cost: 0.0");
        totalCostLabel.setBounds(300, yPosition, 200, 25);
        add(totalCostLabel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(530, yPosition + 30, 100, 30);
        add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkStock()) {
                    updateStock();
                    new ConfirmOrderFrame(getOrderDetails(), totalCost);
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    private void loadStock() {
        try (BufferedReader reader = new BufferedReader(new FileReader("stock.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                stock.add(new StockItem(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2])));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveStock() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt"))) {
            for (StockItem item : stock) {
                writer.write(item.getName() + "," + item.getQuantity() + "," + item.getPrice());
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateTotalCost() {
        totalCost = 0;
        for (int i = 0; i < stock.size(); i++) {
            int quantity = Integer.parseInt(quantityFields.get(i).getText());
            stock.get(i).setOrderQuantity(quantity);
            totalCost += stock.get(i).getPrice() * quantity;
        }
        totalCostLabel.setText("Total Cost: " + totalCost);
    }

    private List<StockItem> getOrderDetails() {
        List<StockItem> orderDetails = new ArrayList<>();
        for (StockItem item : stock) {
            if (item.getOrderQuantity() > 0) {
                orderDetails.add(item);
            }
        }
        return orderDetails;
    }

    private boolean checkStock() {
        for (StockItem item : stock) {
            if (item.getOrderQuantity() > item.getQuantity()) {
                JOptionPane.showMessageDialog(this, "Out of stock: " + item.getName(), "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void updateStock() {
        for (StockItem item : stock) {
            int newStock = item.getQuantity() - item.getOrderQuantity();
            item.setQuantity(newStock);
        }
        saveStock();
    }
}
