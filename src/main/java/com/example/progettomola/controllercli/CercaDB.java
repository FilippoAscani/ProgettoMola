package com.example.progettomola.controllercli;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercaDB {


    private CercaDB(){

    }


    private static final Logger logger = LoggerFactory.getLogger(CercaDB.class);


    public static boolean cercaU(String query, String username, String password) {

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation user : {}", e.getMessage());

            return false;
        }

    }

    public static boolean cercaA(String query, String username, String password) {

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation artist : {}", e.getMessage());
            return false;

        }

    }

    public static boolean cercaS(String query, String username, String password) {

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation sponsor : {}", e.getMessage());

            return false;
        }

    }








}



