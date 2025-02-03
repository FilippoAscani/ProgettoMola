package com.example.progettomola;


public class UserRegisterCSV {


    public UserRegisterCSV() {

    }

    public void registrati(User user) {

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
    }

    public void registraSponsorDB(Sponsor sponsor) {
        //registra sponsor ma sul db
    }

    public void registraArtist(Artist artist) {

        ArtistDAOImplCSV artistCSV = new ArtistDAOImplCSV();
        artistCSV.AddArtist(artist);
        //registra artist su csv
    }

    public void registraArtistDB(Artist artist) {
        //registra artist su db
    }

}