package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {
    private String username;

    public HomePageFrame(String username) {
        this.username = username;
        setTitle("Home Page");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome " + username + "!");
        welcomeLabel.setBounds(450, 60, 300, 30);
        add(welcomeLabel);

        JButton stockUpdateButton = new JButton("Stock Update");
        JButton takeOrderButton = new JButton("Take Order");
        JButton orderHistoryButton = new JButton("Order History");
        JButton rawMaterialsButton = new JButton("Raw Materials");
        JButton distributionButton = new JButton("Distribution");

        stockUpdateButton.setBounds(400, 110, 200, 30);
        takeOrderButton.setBounds(400, 160, 200, 30);
        orderHistoryButton.setBounds(400, 210, 200, 30);
        rawMaterialsButton.setBounds(400, 260, 200, 30);
        distributionButton.setBounds(400, 310, 200, 30);

        add(stockUpdateButton);
        add(takeOrderButton);
        add(orderHistoryButton);
        add(rawMaterialsButton);
        add(distributionButton);

        stockUpdateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StockUpdateFrame();
            }
        });

        takeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TakeOrderFrame();
            }
        });

        orderHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OrderHistoryFrame();
            }
        });

        rawMaterialsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RawMaterialsFrame().setVisible(true);
            }
        });

        distributionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DistributionFrame().setVisible(true);
            }
        });

        setVisible(true);
    }
}
