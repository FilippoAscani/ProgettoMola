package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.dao.SponsorDAO;
import com.example.progettomola.model.entity.Sponsor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAOImplDB implements SponsorDAO {


    private static final Logger logger = LoggerFactory.getLogger(SponsorDAOImplDB.class);

    @Override
    public void addSponsor(Sponsor sponsor) {



        String sql = "INSERT INTO sponsors(id,username,password ) VALUES (?,?,?)";

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, sponsor.getId());
                ps.setString(2, sponsor.getUsername());
                ps.setString(3, sponsor.getPassword());
                ps.executeUpdate();
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile aggiungere sponsor impldb");
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        String sql = "UPDATE sponsors SET username = ?, WHERE username = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, sponsor.getUsername());
                ps.executeUpdate();
            }

        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile aggiornare sponsor impldb");
        }
    }

    @Override
    public void deleteSponsor(Sponsor sponsor) {
        String sql = "DELETE FROM sponsors WHERE nome = ?";
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, sponsor.getUsername());
                ps.executeUpdate();
            }
        }
        catch(SQLException | DBConnectionException e){
            logger.info("impossibile eliminare sponsor impldb");
        }
    }

    @Override
    public List<Sponsor> getSponsors() {
        List<Sponsor> sponsors = new ArrayList<>();
        String sql = "SELECT * FROM sponsors";
        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
            }

            while(rs.next()) {

                Sponsor sponsor = new Sponsor(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));

                sponsors.add(sponsor);
            }

        }
        catch (SQLException | DBConnectionException e){
            logger.info("impossibile visualizzare sponsors impldb");
        }

        return sponsors;
    }

    @Override
    public Sponsor getSponsor(int id) {
        String sql = "SELECT * FROM sponsors WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getInstance().getConnection();
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                rs = ps.executeQuery();
            }

            if(rs.next()) {
                return new Sponsor
                                (rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("password"));
            }


        }
        catch (SQLException | DBConnectionException e) {
            logger.info("impossibile visualizzare sponsor impldb");
        }

        return null;
    }
}
