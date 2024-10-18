package com.lzcalderaro.registrationClient;

import com.lzcalderaro.registrationClient.connection.Database;
import com.lzcalderaro.registrationClient.screens.MainScreen;


public class Main {
    public static void main(String[] args) {
        new MainScreen();

        // Creating database tables
        Database.createTables();
    }
}