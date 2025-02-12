package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.ReviewDAO;
import com.example.progettomola.model.entity.Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImplCSV implements ReviewDAO {


    public ReviewDAOImplCSV() {

        /**/

    }

    private static final String FILE = "review.csv";

    @Override
    public void addReview(Review review) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( FILE, true));
            bw.write(review.getId() + "," + review.getContent());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiungere recensione", e);
        }



    }

    @Override
    public void updateReview(Review review) {
        List<Review> reviews = getReviews();
        try {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Review r : reviews) {
                    if (r.getId() == review.getId()) {
                        br.write(review.getId() + "," + review.getContent());
                    } else {
                        br.write(r.getId() + "," + r.getContent());
                    }
                    br.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiornare recensione", e);
        }

    }

    @Override
    public void deleteReview(Review review) {
        List<Review> reviews = getReviews();
        try {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Review r : reviews) {
                    if (r.getId() != review.getId()) {
                        bw.write(r.getId() + "," + r.getContent());
                        bw.newLine();
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile eliminare recensione", e);
        }
    }

    @Override
    public List<Review> getReviews() {

        List<Review> reviews = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    reviews.add(new Review(Integer.parseInt(colonne[0]), colonne[1]));

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile ottenere recensioni", e);
        }
        return reviews;

    }

    @Override
    public Review getReview(int id) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    if (Integer.parseInt(colonne[0]) == id) {
                        return new Review(id, colonne[1]);
                    }

                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile ottenere recensione", e);
        }
        return null;
    }
}