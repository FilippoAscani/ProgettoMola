package com.example.progettomola;

import com.example.progettomola.exceptions.DBConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection {

    private static DatabaseConnection instance = null;  // Singleton instance
    private Connection conn = null;  // Connection object

    private DatabaseConnection() {
        // Costruttore privato per impedire la creazione di più istanze
    }

    // Metodo per ottenere l'istanza singleton della connessione
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Metodo per ottenere una connessione al database
    public Connection getConnection() throws DBConnectionException {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            // Se la connessione è null o chiusa, la riapriamo
            if (conn == null || conn.isClosed()) {
                if (input == null) {
                    throw new DBConnectionException("Configurazione non trovata!");
                } else {
                    Properties properties = new Properties();
                    properties.load(input);

                    String dbUrl = properties.getProperty("db.url");
                    String dbUsr = properties.getProperty("db.user");
                    String dbPwd = properties.getProperty("db.password");

                    conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
                }
            }
        } catch (IOException | SQLException e) {
            throw new DBConnectionException("Errore di connessione al db: " + e.getMessage());
        }
        return conn;
    }

    // Metodo per chiudere la connessione (quando necessario)
    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
