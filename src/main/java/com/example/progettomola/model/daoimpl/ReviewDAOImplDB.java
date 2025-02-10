package com.example.progettomola.model.daoimpl;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.model.dao.ReviewDAO;
import com.example.progettomola.model.entity.Review;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImplDB implements ReviewDAO {
    @Override
    public void addReview(Review review) {
        String sql = "INSERT INTO reviews(id,content) VALUES (?,?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, review.getId());
            ps.setString(2, review.getContent());
            ps.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReview(Review review) {
        String sql = "UPDATE reviews SET  content = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, review.getContent());
            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReview(Review review) {
        String sql = "DELETE FROM reviews WHERE id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, review.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Review review = new Review(
                        rs.getInt("id"),
                        rs.getString("content"));

                reviews.add(review);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return reviews;
    }

    @Override
    public Review getReview(int id) {
        String sql = "SELECT * FROM reviews WHERE id = ?";


        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Review
                                (rs.getInt("id"),
                                rs.getString("content"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
