package com.example.progettomola.model.daoimpl;


import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.dao.UserDAO;
import com.example.progettomola.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplDB implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImplDB.class);

    @Override
    public void addUser(User user) {

        String sql = "INSERT INTO users(id,nome, cognome, username, password ) VALUES (?,?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user.getId());
                ps.setString(2, user.getNome());
                ps.setString(3, user.getCognome());
                ps.setString(4, user.getUsername());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile aggiungere user impldb");
        }
    }



    @Override
    public User getUser(int id) {
        String sql = "SELECT id, nome, cognome, password, username FROM users WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                rs = ps.executeQuery();
            }

            if(rs.next()) {
                return new User
                        (rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("password"),
                        rs.getString("username"));
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile visualizzare user impldb");
        }

        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, nome, cognome, password, username FROM users";
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
            }

            while(rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("password"),
                        rs.getString("username"));

                users.add(user);
            }

        }
        catch (SQLException | DBConnectionException e){
            logger.info("impossibile visualizzare users impldb");
        }

        return users;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, cognome = ? WHERE username = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, user.getNome());
                ps.setString(2, user.getCognome());
                ps.setString(3, user.getUsername());
                ps.executeUpdate();
            }

        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile aggiornare user impldb");
        }

    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE nome = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getNome());
                ps.executeUpdate();
            }
        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile eliminare user impldb");
        }

    }
}
