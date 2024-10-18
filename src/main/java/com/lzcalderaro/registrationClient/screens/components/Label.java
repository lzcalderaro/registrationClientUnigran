package com.lzcalderaro.registrationClient.screens.components;

import javax.swing.*;
import java.awt.*;

public class Label {

    public JLabel create(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setPreferredSize(new Dimension(100, 30));
        return label;
    }
}
