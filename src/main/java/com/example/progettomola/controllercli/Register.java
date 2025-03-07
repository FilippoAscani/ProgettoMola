package com.example.progettomola.controllercli;


import com.example.progettomola.model.daoimpl.*;
import com.example.progettomola.model.entity.*;

public class Register {


    private Register() {

    }

    public static void registraUserCSV(User user) {

        UserDAOImplCSV userCSV = new UserDAOImplCSV();
        userCSV.addUser(user);

    }

    public static void registraUserDB(User user) {

        UserDAOImplDB userDB = new UserDAOImplDB();
        userDB.addUser(user);


    }

    public static void registraSponsorCSV(Sponsor sponsor) {
        //registra sponsor sul file csv
        SponsorDAOImplCSV artistCSV = new SponsorDAOImplCSV();
        artistCSV.addSponsor(sponsor);
    }

    public static void registraSponsorDB(Sponsor sponsor) {
        //registra sponsor ma sul db
        SponsorDAOImplDB artistCSV = new SponsorDAOImplDB();
        artistCSV.addSponsor(sponsor);
    }

    public static void registraArtistCSV(Artist artist) {

        ArtistDAOImplCSV artistCSV = new ArtistDAOImplCSV();
        artistCSV.addArtist(artist);
        //registra artist su csv
    }

    public static void registraArtistDB(Artist artist) {
        //registra artist su db
        ArtistDAOImplDB artistDB = new ArtistDAOImplDB();
        artistDB.addArtist(artist);
    }

    public static void registraShowCSV(Show show) {
        ShowDAOImplCSV showCSV = new ShowDAOImplCSV();
        showCSV.addShow(show);
    }

    public static void registraShowDB(Show show) {
        ShowDAOImplDB showDB = new ShowDAOImplDB();
        showDB.addShow(show);
    }

    public static void registraReviewCSV(Review review) {
        ReviewDAOImplCSV reviewCSV = new ReviewDAOImplCSV();
        reviewCSV.addReview(review);
    }

    public static void registraReviewDB(Review review) {
        ReviewDAOImplDB reviewDB = new ReviewDAOImplDB();
        reviewDB.addReview(review);
    }

    public static void registraRequestCSV(Request request) {
        RequestDAOImplCSV requestCSV = new RequestDAOImplCSV();
        requestCSV.addRequest(request);
    }

    public static void registraRequestDB(Request request) {
        RequestDAOImplDB requestDB = new RequestDAOImplDB();
        requestDB.addRequest(request);
    }

}