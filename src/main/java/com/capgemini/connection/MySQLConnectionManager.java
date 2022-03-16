package com.capgemini.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionManager implements ConnectionManager{

    @Override
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/products";
        String userName = "root";
        String password = "Parola1234!";
        return DriverManager.getConnection(url, userName, password);
    }
}
