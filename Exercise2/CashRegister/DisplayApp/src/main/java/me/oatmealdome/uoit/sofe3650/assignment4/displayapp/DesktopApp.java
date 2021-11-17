/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.oatmealdome.uoit.sofe3650.assignment4.displayapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import me.oatmealdome.uoit.sofe3650.assignment4.register.CashRegister;
import me.oatmealdome.uoit.sofe3650.assignment4.register.IRegisterObserver;
import me.oatmealdome.uoit.sofe3650.assignment4.register.Product;
import me.oatmealdome.uoit.sofe3650.assignment4.register.ProductDB;

/**
 *
 * @author julian
 */
public class DesktopApp extends JFrame implements IRegisterObserver {

    private CashRegister register;

    private JLabel productLabel;
    private JTextField textField;

    public DesktopApp(CashRegister register) {
        super("Cash Register");
        init();

        this.register = register;
        this.register.addObserver(this);
    }

    private void init() {
        // Add border around panes
        this.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        // Make label
        productLabel = new JLabel("Waiting for item.");
        add(productLabel);
        
        // Make text field of 20 width and one line height
        textField = new JTextField(20);
        textField.setMaximumSize(textField.getPreferredSize());
        add(textField);
        
        // Make button which sets the current UPC based on the JTextField
        JButton scanButton = new JButton("Scan");
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register.setCurrentProductUpc(textField.getText());
            }
        });
        add(scanButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 125);
        setLocationRelativeTo(null);
    }

    @Override
    public void productUpdated(Product product) {
        // Set the label based on the product
        productLabel.setText(product != null ? product.GetName() : "Unknown");
    }

    public static void main(String[] args) {
        // Create a ProductDB with some dummy data
        ProductDB productDB = new ProductDB();
        productDB.addProductInfo("UPC123456789", new Product("Testing Product"));

        // Create the CashRegister
        CashRegister register = new CashRegister(productDB);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopApp(register).setVisible(true);
            }
        });
    }
}
