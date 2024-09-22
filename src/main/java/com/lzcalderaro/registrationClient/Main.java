package com.lzcalderaro.registrationClient;

import com.lzcalderaro.registrationClient.entities.Client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(
                "Luiz Calderaro",
                "test@test.com",
                "1A2B3C4D5E",
                "+123 - 123456789"
        );

        JOptionPane.showMessageDialog(null, client.toString());
    }
}