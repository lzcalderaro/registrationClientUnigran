package com.lzcalderaro.registrationClient.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/registrationClient";
    private static final String USER = "admin";
    private static final String PASSWORD = "123456";


    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully.");

        } catch (ClassNotFoundException e) {

            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {

            System.err.println("Connection failed. Check your database URL, username, and password.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void createTables() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS clients ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "email VARCHAR(100), "
                + "identity_number VARCHAR(100), "
                + "mobile_number VARCHAR(15))";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("Client table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
