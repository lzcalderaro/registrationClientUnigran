package com.lzcalderaro.registrationClient.screens.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Button {

    public JButton create(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(30, 144, 255));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
            }

            @Override
            public void setBorder(Border border) {
                // No border
            }

            @Override
            protected void paintBorder(Graphics g) {
                // No border
            }
        };
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(120, 40));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        return button;
    }
}
