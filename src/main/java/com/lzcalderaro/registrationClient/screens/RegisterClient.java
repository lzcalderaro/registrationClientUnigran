package com.lzcalderaro.registrationClient.screens;

import com.lzcalderaro.registrationClient.entities.Client;
import com.lzcalderaro.registrationClient.screens.components.Button;
import com.lzcalderaro.registrationClient.screens.components.Row;
import com.lzcalderaro.registrationClient.screens.components.TextField;

import javax.swing.*;
import java.awt.*;

public class RegisterClient extends JFrame {

    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField idField;
    private final JTextField mobileField;
    private MainScreen mainScreen;

    public RegisterClient(MainScreen mainScreen) {

        this.mainScreen = mainScreen;

        setLocation(mainScreen.getX(), mainScreen.getY());

        try {
            // Force the "Metal" Look and Feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel paddedPanel = new JPanel(new GridBagLayout());
        paddedPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        paddedPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        Row row = new Row();
        TextField textField = new TextField();
        paddedPanel.add(row.create("Name:", nameField = textField.create()), gbc);

        gbc.gridy = 1;
        paddedPanel.add(row.create("Email:", emailField = textField.create()), gbc);

        gbc.gridy = 2;
        paddedPanel.add(row.create("ID:", idField = textField.create()), gbc);

        gbc.gridy = 3;
        paddedPanel.add(row.create("Mobile Number:", mobileField = textField.create()), gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.WHITE);

        Button button = new Button();
        JButton saveButton = button.create("Save");
        JButton closeButton = button.create("Close");

        buttonPanel.add(saveButton);
        buttonPanel.add(closeButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        paddedPanel.add(buttonPanel, gbc);

        add(paddedPanel, BorderLayout.CENTER);

        saveButton.addActionListener(e -> saveClientData());
        closeButton.addActionListener(e -> {
            dispose();
            mainScreen.setVisible(true);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void saveClientData() {
        String name = nameField.getText();
        String email = emailField.getText();
        String id = idField.getText();
        String mobile = mobileField.getText();

        Client client = new Client(name, email, id, mobile);

        if (name.isEmpty() || email.isEmpty() || id.isEmpty() || mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Client data saved successfully!" + System.lineSeparator() + client);
        }
    }

}
