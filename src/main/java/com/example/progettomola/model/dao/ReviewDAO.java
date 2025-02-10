package com.example.progettomola.model.dao;

import com.example.progettomola.model.entity.Review;

import java.util.List;

public interface ReviewDAO {

    void addReview(Review review); //lo sviluppatore si iscrive(?)
    void updateReview(Review review); //lo sviluppatore aggiorna le sua info
    void deleteReview(Review review); // si disinscrive(?)
    List<Review> getReviews(); // forse non serve sapere tutti gli sviluppatori
    Review getReview(int id); //

}
