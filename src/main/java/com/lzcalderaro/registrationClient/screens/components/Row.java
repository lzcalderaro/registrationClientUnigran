package com.lzcalderaro.registrationClient.screens.components;

import javax.swing.*;
import java.awt.*;

public class Row {

    private final Label label = new Label();

    public JPanel create(String labelText, JTextField textField) {
        JPanel rowPanel = new JPanel(new GridBagLayout());
        rowPanel.setBackground(Color.LIGHT_GRAY);
        rowPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.weightx = 0;
        rowPanel.add(label.create(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        rowPanel.add(textField, gbc);

        return rowPanel;
    }

}
