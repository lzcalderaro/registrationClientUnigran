package com.lzcalderaro.registrationClient.screens;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    public MainScreen() {
        setTitle("Main Screen");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newClientMenuItem = new JMenuItem("New Client");
        JMenuItem newCloseMenuClient = new JMenuItem("Close");

        newClientMenuItem.addActionListener(e -> {
            new RegisterClient(MainScreen.this);
            setVisible(false); // Hide the main screen
        });

        newCloseMenuClient.addActionListener(e -> {
            System.exit(0);
        });

        fileMenu.add(newClientMenuItem);
        fileMenu.add(newCloseMenuClient);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setVisible(true);
        setLocationRelativeTo(null);
    }

}
