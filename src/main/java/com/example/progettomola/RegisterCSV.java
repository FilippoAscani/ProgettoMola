package com.example.progettomola;


public class RegisterCSV {


    public RegisterCSV() {

    }

    public void registraUserCSV(User user) {

        UserDAOImplCSV userCSV = new UserDAOImplCSV();
        userCSV.addUser(user);
        //controllo hasmap();
        //anche metododb  che cazzo

    }

    public void registraUserDB(User user) {

        UserDAOImplDB userDB = new UserDAOImplDB();
        userDB.addUser(user);
        //controllo hasmap();
        //anche metododb  che cazzo

    }

    public void registraSponsor(Sponsor sponsor) {
        //registra sponsor sul file csv
        SponsorDAOImplCSV artistCSV = new SponsorDAOImplCSV();
        artistCSV.addSponsor(sponsor);
    }

    public void registraSponsorDB(Sponsor sponsor) {
        //registra sponsor ma sul db
        SponsorDAOImplDB artistCSV = new SponsorDAOImplDB();
        artistCSV.addSponsor(sponsor);
    }

    public void registraArtist(Artist artist) {

        ArtistDAOImplCSV artistCSV = new ArtistDAOImplCSV();
        artistCSV.addArtist(artist);
        //registra artist su csv
    }

    public void registraArtistDB(Artist artist) {
        //registra artist su db
        ArtistDAOImplDB artistDB = new ArtistDAOImplDB();
        artistDB.addArtist(artist);
    }

    public void registraShowCSV(Show show) {
        ShowDAOImplCSV showCSV = new ShowDAOImplCSV();
        showCSV.addShow(show);
    }

    public void registraShowDB(Show show) {
        //db
    }

    public void registraReviewCSV(Review review) {
        ReviewDAOImplCSV reviewCSV = new ReviewDAOImplCSV();
        reviewCSV.addReview(review);
    }

    public void registraReviewDB(Review review) {
        //db
    }

    public void registraRequestCSV(Request request) {
        RequestDAOImplCSV requestCSV = new RequestDAOImplCSV();
        requestCSV.addRequest(request);
    }

    public void registraRequestDB(Request request) {
        //db
    }

}