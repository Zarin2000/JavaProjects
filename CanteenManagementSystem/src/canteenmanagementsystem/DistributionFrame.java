package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DistributionFrame extends JFrame {
    private JTextArea distributionArea;
    private JComboBox<String> chiefComboBox;
    private JComboBox<String> itemComboBox;
    private JTextField quantityField;
    private JButton distributeButton;
    private JButton viewHistoryButton;

    public DistributionFrame() {
        setTitle("Distribution Management");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        distributionArea = new JTextArea();
        distributionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(distributionArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Chief No:"));
        chiefComboBox = new JComboBox<>(new String[]{"Chief1", "Chief2", "Chief3"});
        inputPanel.add(chiefComboBox);

        inputPanel.add(new JLabel("Item:"));
        itemComboBox = new JComboBox<>();
        loadItemsIntoComboBox();
        inputPanel.add(itemComboBox);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        distributeButton = new JButton("Distribute");
        inputPanel.add(distributeButton);

        viewHistoryButton = new JButton("View History");
        inputPanel.add(viewHistoryButton);

        add(inputPanel, BorderLayout.SOUTH);

        distributeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                distributeItems();
            }
        });

        viewHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewDistributionHistory();
            }
        });

        loadDistributionHistory();
    }

    private void loadDistributionHistory() {
        distributionArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader("distribution_history.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                distributionArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadItemsIntoComboBox() {
        try (BufferedReader br = new BufferedReader(new FileReader("raw_materials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                itemComboBox.addItem(parts[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void distributeItems() {
        String chief = (String) chiefComboBox.getSelectedItem();
        String item = (String) itemComboBox.getSelectedItem();
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
                    if (currentQuantity >= quantity) {
                        currentQuantity -= quantity;
                        line = parts[0] + "," + currentQuantity;
                        itemFound = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Not enough stock!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (itemFound) {
            if (originalFile.delete()) {
                if (!tempFile.renameTo(originalFile)) {
                    JOptionPane.showMessageDialog(this, "Failed to rename temporary file!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete original file!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter("distribution_history.txt", true))) {
                pw.println(chief + "," + item + "," + quantity + "," + new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadDistributionHistory();
        } else {
            JOptionPane.showMessageDialog(this, "Item not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewDistributionHistory() {
        StringBuilder history = new StringBuilder("Distribution History:\n");
        try (BufferedReader br = new BufferedReader(new FileReader("distribution_history.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                history.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, history.toString(), "Distribution History", JOptionPane.INFORMATION_MESSAGE);
    }
}
