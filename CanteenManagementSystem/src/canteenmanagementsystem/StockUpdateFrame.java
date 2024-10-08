package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockUpdateFrame extends JFrame {
    private JTextArea stockArea;
    private List<JCheckBox> itemCheckBoxes;
    private List<StockItem> stock;

    public StockUpdateFrame() {
        setTitle("Stock Update");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel stockLabel = new JLabel("Stock Update:");
        stockLabel.setBounds(20, 20, 200, 25);
        add(stockLabel);

        itemCheckBoxes = new ArrayList<>();
        stock = new ArrayList<>();

        loadStock();

        stockArea = new JTextArea();
        updateStockArea();
        stockArea.setBounds(20, 50, 350, 350);
        stockArea.setEditable(false);
        add(stockArea);

        int yPosition = 50;
        for (StockItem item : stock) {
            JCheckBox checkBox = new JCheckBox(item.getName());
            checkBox.setBounds(400, yPosition, 150, 25);
            add(checkBox);
            itemCheckBoxes.add(checkBox);
            yPosition += 30;
        }

        JButton increaseButton = new JButton("Increase Stock");
        increaseButton.setBounds(20, 420, 150, 30);
        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < itemCheckBoxes.size(); i++) {
                    if (itemCheckBoxes.get(i).isSelected()) {
                        increaseStock(stock.get(i).getName(), 1);
                    }
                }
                updateStockArea();
                saveStock();
            }
        });
        add(increaseButton);

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

    private void updateStockArea() {
        StringBuilder stockText = new StringBuilder();
        for (StockItem item : stock) {
            stockText.append(item.getName()).append(": ").append(item.getQuantity()).append(", Price: ").append(item.getPrice()).append("\n");
        }
        stockArea.setText(stockText.toString());
    }

    private void increaseStock(String itemName, int amount) {
        for (StockItem item : stock) {
            if (item.getName().equals(itemName)) {
                item.setQuantity(item.getQuantity() + amount);
                break;
            }
        }
    }
}
