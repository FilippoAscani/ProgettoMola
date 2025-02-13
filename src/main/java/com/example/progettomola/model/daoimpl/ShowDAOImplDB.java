package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.dao.ShowDAO;
import com.example.progettomola.model.entity.Show;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImplDB implements ShowDAO {

    private static final Logger logger = LoggerFactory.getLogger(ShowDAOImplDB.class);

    @Override
    public void addShow(Show show) {
        String sql = "INSERT INTO shows(id,titolo,capienza,tipo) VALUES (?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, show.getId());
                ps.setString(2, show.getTitolo());
                ps.setInt(3, show.getCapienza());
                ps.setString(4, show.getTipo());
                ps.executeUpdate();
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile aggiungere show impldb");
        }
    }

    @Override
    public void updateShow(Show show) {
        String sql = "UPDATE shows SET titolo = ?, capienza = ? WHERE tipo = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, show.getTitolo());
                ps.setInt(2, show.getCapienza());
                ps.setString(3, show.getTipo());
                ps.executeUpdate();
            }

        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile aggiornare show impldb");
        }
    }

    @Override
    public void deleteShow(Show show) {
        String sql = "DELETE FROM shows WHERE titolo = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, show.getTitolo());
                ps.executeUpdate();
            }
        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile eliminare show impldb");
        }
    }

    @Override
    public List<Show> getShows() {
        List<Show> shows = new ArrayList<>();
        String sql = "SELECT id, titolo, capienza, tipo FROM shows";
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
            }

            while(rs.next()) {

                Show show = new Show(
                        rs.getInt("id"),
                        rs.getString("titolo"),
                        rs.getInt("capienza"),
                        rs.getString("tipo"));

                shows.add(show);
            }

        }
        catch (SQLException | DBConnectionException e){
            logger.info("impossibile visualizzare shows impldb");
        }

        return shows;
    }

    @Override
    public Show getShow(int id) {
        String sql = "SELECT id, titolo, capienza, tipo FROM shows WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                rs = ps.executeQuery();
            }

            if(rs.next()) {
                return new Show
                                (rs.getInt("id"),
                                rs.getString("titolo"),
                                rs.getInt("capienza"),
                                rs.getString("tipo"));
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile visualizzare show impldb");
        }

        return null;
    }
}
