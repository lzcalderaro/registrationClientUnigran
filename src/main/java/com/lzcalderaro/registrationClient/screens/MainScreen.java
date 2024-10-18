package com.lzcalderaro.registrationClient.screens;

import com.lzcalderaro.registrationClient.dao.ClientDAO;
import com.lzcalderaro.registrationClient.entities.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.lzcalderaro.registrationClient.screens.components.Button;

public class MainScreen extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private ClientDAO clientDAO;

    public MainScreen() {

        try {
            // Force the "Metal" Look and Feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Main Screen");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        clientDAO = new ClientDAO();

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Identity Number", "Email", "Mobile"}, 0);
        table = new JTable(tableModel);
        loadData();

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newClientMenuItem = new JMenuItem("New Client");
        JMenuItem newCloseMenuClient = new JMenuItem("Close");

        newClientMenuItem.addActionListener(e -> {
            new RegisterClient(MainScreen.this, null);
            setVisible(false); // Hide the main screen
        });

        newCloseMenuClient.addActionListener(e -> {
            System.exit(0);
        });

        fileMenu.add(newClientMenuItem);
        fileMenu.add(newCloseMenuClient);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        Button button = new Button();
        JButton editButton = button.create("Edit Client");
        JButton deleteButton = button.create("Delete Client");

        editButton.addActionListener(new EditButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void loadData() {
        tableModel.setRowCount(0);

        List<Client> clients = clientDAO.getAllClients();
        for (Client client : clients) {
            tableModel.addRow(new Object[]{
                    client.getId(),
                    client.getName(),
                    client.getIdentityNumber(),
                    client.getEmail(),
                    client.getMobileNumber()
            });
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int clientId = (int) tableModel.getValueAt(selectedRow, 0);

                Client client = clientDAO.getClientById(clientId);

                if (client != null) {
                    new RegisterClient(MainScreen.this, client);
                    setVisible(false); // Hide the main screen
                }
            } else {
                JOptionPane.showMessageDialog(MainScreen.this, "Please select a client to edit.");
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {

                int clientId = (int) tableModel.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(MainScreen.this, "Are you sure you want to delete this client?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    clientDAO.deleteClient(clientId);
                    loadData();
                }
            } else {
                JOptionPane.showMessageDialog(MainScreen.this, "Please select a client to delete.");
            }
        }
    }
}
