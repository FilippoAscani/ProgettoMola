package com.example.progettomola;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImplCSV implements ReviewDAO {


    public ReviewDAOImplCSV() {

    }



    @Override
    public void addReview(Review review) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "review.csv", true));
            bw.write(review.getId() + "," + review.getContent());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void updateReview(Review review) {
        List<Review> reviews = getReviews();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("review.csv", true));
            for (Review r : reviews) {
                if(r.getId() == review.getId()){
                    br.write(review.getId() + "," +review.getContent());
                }
                else{
                    br.write(r.getId() + "," +r.getContent());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteReview(Review review) {
        List<Review> reviews = getReviews();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("artist.csv", true));
            for (Review r : reviews) {
                if(r.getId() != review.getId()){
                    bw.write(r.getId() + "," +r.getContent());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Review> getReviews() {

        List<Review> reviews = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("review.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                reviews.add(new Review(Integer.parseInt(colonne[0]), colonne[1]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;

    }

    @Override
    public Review getReview(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("review.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new Review(id, colonne[1]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}