package com.example.progettomola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArtistDAOImplCSV implements ArtistDAO {


    public ArtistDAOImplCSV() {

    }



    @Override
    public void AddArtist(Artist artist) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "artist.csv", true));
            bw.write(artist.getNome() + "," + artist.getPassword());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void UpdateArtist(Artist artist) {

    }

    @Override
    public void DeleteArtist(Artist artist) {

    }

    @Override
    public List<Artist> GetAllArtists() {
        return List.of();
    }

    @Override
    public Artist GetArtist(int id) {
        return null;
    }
}
