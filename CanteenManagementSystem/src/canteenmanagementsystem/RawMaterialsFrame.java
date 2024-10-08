package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RawMaterialsFrame extends JFrame {

    private JTextArea rawMaterialsArea;
    private JButton increaseStockButton;
    private JButton updateStockButton;
    private JTextField itemField;
    private JTextField quantityField;
    private JButton viewTotalStockButton;

    public RawMaterialsFrame() {
        setTitle("Raw Materials");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        rawMaterialsArea = new JTextArea();
        rawMaterialsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rawMaterialsArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Item:"));
        itemField = new JTextField();
        inputPanel.add(itemField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        increaseStockButton = new JButton("Increase Stock");
        inputPanel.add(increaseStockButton);

        updateStockButton = new JButton("Update Stock");
        inputPanel.add(updateStockButton);

        add(inputPanel, BorderLayout.SOUTH);

        increaseStockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increaseStock();
            }
        });

        updateStockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStock();
            }
        });
        loadRawMaterials();
    }

    private void loadRawMaterials() {
        rawMaterialsArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader("raw_materials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                rawMaterialsArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void increaseStock() {
        String item = itemField.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean itemFound = false;
        File tempFile = new File("raw_materials_temp.txt");
        File originalFile = new File("raw_materials.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(originalFile));
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(item)) {
                    int currentQuantity = Integer.parseInt(parts[1]);
                    currentQuantity += quantity;
                    line = parts[0] + "," + currentQuantity;
                    itemFound = true;
                }
                pw.println(line);
            }
            if (!itemFound) {
                pw.println(item + "," + quantity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (originalFile.delete()) {
            if (!tempFile.renameTo(originalFile)) {
                JOptionPane.showMessageDialog(this, "Failed to rename temporary file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete original file!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadRawMaterials();
    }

    private void updateStock() {
        String item = itemField.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean itemFound = false;
        File tempFile = new File("raw_materials_temp.txt");
        File originalFile = new File("raw_materials.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(originalFile));
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(item)) {
                    line = parts[0] + "," + quantity;
                    itemFound = true;
                }
                pw.println(line);
            }
            if (!itemFound) {
                JOptionPane.showMessageDialog(this, "Item not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (originalFile.delete()) {
            if (!tempFile.renameTo(originalFile)) {
                JOptionPane.showMessageDialog(this, "Failed to rename temporary file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete original file!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        loadRawMaterials();
    }

    private void viewTotalStock() {
        StringBuilder totalStock = new StringBuilder("Total Stock:\n");
        try (BufferedReader br = new BufferedReader(new FileReader("raw_materials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalStock.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, totalStock.toString(), "Total Stock", JOptionPane.INFORMATION_MESSAGE);
    }

}
