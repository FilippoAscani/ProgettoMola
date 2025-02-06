package com.example.progettomola;


public class RegisterCSV {


    public RegisterCSV() {

    }

    public void registraUser(User user) {

        UserDAOImplCSV userCSV = new UserDAOImplCSV();
        userCSV.addUser(user);
        //controllo hasmap();
        //anche metododb  che cazzo

    }

    public void registratiDB(User user) {

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

}