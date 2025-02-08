package com.example.progettomola.Model.DAOImpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.Model.DAO.RequestDAO;
import com.example.progettomola.Model.Entity.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImplDB implements RequestDAO {
    @Override
    public void addRequest(Request request) {
        String sql = "INSERT INTO requests(id,nome,capienza,tipo) VALUES (?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getId());
            ps.setString(2, request.getNome());
            ps.setInt(3, request.getCapienza());
            ps.setString(4, request.getTipo());
            ps.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRequest(Request request) {
        String sql = "UPDATE requests SET name = ?, capienza = ? WHERE tipo = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, request.getNome());
            ps.setInt(2, request.getCapienza());
            ps.setString(3, request.getTipo());
            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRequest(Request request) {
        String sql = "DELETE FROM requests WHERE nome = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, request.getNome());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> getRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Request request = new Request(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("capienza"),
                        rs.getString("tipo"));

                requests.add(request);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return requests;
    }

    @Override
    public Request getRequest(int id) {
        String sql = "SELECT * FROM requests WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Request
                                (rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("capienza"),
                                rs.getString("tipo"));
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
