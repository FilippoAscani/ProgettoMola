package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.model.dao.SponsorDAO;
import com.example.progettomola.model.entity.Sponsor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAOImplDB implements SponsorDAO {

    @Override
    public void addSponsor(Sponsor sponsor) {
        String sql = "INSERT INTO sponsors(id,username,password ) VALUES (?,?,?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sponsor.getId());
            ps.setString(2, sponsor.getUsername());
            ps.setString(3, sponsor.getPassword());
            ps.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        String sql = "UPDATE sponsors SET username = ?, WHERE username = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sponsor.getUsername());
            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSponsor(Sponsor sponsor) {
        String sql = "DELETE FROM sponsors WHERE nome = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, sponsor.getUsername());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Sponsor> getSponsors() {
        List<Sponsor> sponsors = new ArrayList<>();
        String sql = "SELECT * FROM sponsors";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Sponsor sponsor = new Sponsor(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));

                sponsors.add(sponsor);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return sponsors;
    }

    @Override
    public Sponsor getSponsor(int id) {
        String sql = "SELECT * FROM sponsors WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Sponsor
                                (rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("password"));
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
