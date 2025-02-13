package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.dao.RequestDAO;
import com.example.progettomola.model.entity.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImplDB implements RequestDAO {

    private static final Logger logger = LoggerFactory.getLogger(RequestDAOImplDB.class);


    @Override
    public void addRequest(Request request) {
        String sql = "INSERT INTO requests(id,nome,capienza,tipo) VALUES (?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, request.getId());
                ps.setString(2, request.getNome());
                ps.setInt(3, request.getCapienza());
                ps.setString(4, request.getTipo());
                ps.executeUpdate();
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile aggiungere request impldb");
        }
    }

    @Override
    public void updateRequest(Request request) {
        String sql = "UPDATE requests SET name = ?, capienza = ? WHERE tipo = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, request.getNome());
                ps.setInt(2, request.getCapienza());
                ps.setString(3, request.getTipo());
                ps.executeUpdate();
            }

        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile aggiornare request impldb");
        }
    }

    @Override
    public void deleteRequest(Request request) {
        String sql = "DELETE FROM requests WHERE nome = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, request.getNome());
                ps.executeUpdate();
            }
        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile eliminare request impldb");
        }
    }

    @Override
    public List<Request> getRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
            }

            while(rs.next()) {

                Request request = new Request(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("capienza"),
                        rs.getString("tipo"));

                requests.add(request);
            }

        }
        catch (SQLException | DBConnectionException e){
            logger.info("impossibile visualizzare requests impldb");
        }

        return requests;
    }

    @Override
    public Request getRequest(int id) {
        String sql = "SELECT * FROM requests WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                rs = ps.executeQuery();
            }

            if(rs.next()) {
                return new Request
                                (rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("capienza"),
                                rs.getString("tipo"));
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile visualizzare request impldb");
        }

        return null;
    }
}
