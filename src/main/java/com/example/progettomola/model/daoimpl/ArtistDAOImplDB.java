package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.dao.ArtistDAO;
import com.example.progettomola.model.entity.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImplDB implements ArtistDAO {
    @Override
    public void addArtist(Artist artist) {
        String sql = "INSERT INTO artists(id,username,password,tipo) VALUES (?,?,?,?)";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, artist.getId());
            ps.setString(2, artist.getUsername());
            ps.setString(3, artist.getPassword());
            ps.setString(4, artist.getTipo());
            ps.executeUpdate();


        }
        catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateArtist(Artist artist) {
        String sql = "UPDATE artists SET username = ?, password = ? WHERE tipo = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, artist.getUsername());
            ps.setString(2, artist.getPassword());
            ps.setString(3, artist.getTipo());
            ps.executeUpdate();

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtist(Artist artist) {
        String sql = "DELETE FROM artists WHERE username = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, artist.getUsername());
            ps.executeUpdate();
        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artists";
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Artist artist = new Artist(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("tipo"));

                artists.add(artist);
            }

        }
        catch (SQLException | DBConnectionException e){
            e.printStackTrace();
        }
        return artists;
    }

    @Override
    public Artist getArtist(int id) {
        String sql = "SELECT * FROM artists WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Artist
                                (rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("tipo"));
            }


        }
        catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
