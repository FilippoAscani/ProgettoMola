package com.example.progettomola.Model.DAOImpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.Model.DAO.ShowDAO;
import com.example.progettomola.Model.Entity.Show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImplDB implements ShowDAO {
    @Override
    public void addShow(Show show) {
        String sql = "INSERT INTO shows(id,titolo,capienza,tipo) VALUES (?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, show.getId());
            ps.setString(2, show.getTitolo());
            ps.setInt(3, show.getCapienza());
            ps.setString(4, show.getTipo());
            ps.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateShow(Show show) {
        String sql = "UPDATE shows SET titolo = ?, capienza = ? WHERE tipo = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, show.getTitolo());
            ps.setInt(2, show.getCapienza());
            ps.setString(3, show.getTipo());
            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteShow(Show show) {
        String sql = "DELETE FROM shows WHERE titolo = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, show.getTitolo());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Show> getShows() {
        List<Show> shows = new ArrayList<>();
        String sql = "SELECT * FROM shows";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Show show = new Show(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getInt("capienza"),
                        rs.getString("tipo"));

                shows.add(show);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return shows;
    }

    @Override
    public Show getShow(int id) {
        String sql = "SELECT * FROM shows WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Show
                                (rs.getInt("id"),
                                rs.getString("titolo"),
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
