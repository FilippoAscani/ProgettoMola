package com.example.progettomola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/register_schema?useUnicode=true&characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "Filippo98";

    public DatabaseConnection() {

    }

    public static Connection getConnection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

}
