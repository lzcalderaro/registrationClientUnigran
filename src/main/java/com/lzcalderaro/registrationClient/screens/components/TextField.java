package com.lzcalderaro.registrationClient.screens.components;

import javax.swing.*;
import java.awt.*;

public class TextField {

    public JTextField create() {
        JTextField textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        return textField;
    }
}
