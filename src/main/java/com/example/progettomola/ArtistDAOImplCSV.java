package com.example.progettomola;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImplCSV implements ArtistDAO {


    public ArtistDAOImplCSV() {

    }



    @Override
    public void AddArtist(Artist artist) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "artist.csv", true));
            bw.write(artist.getUsername() + "," + artist.getPassword());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void UpdateArtist(Artist artist) {
        List<Artist> artists = GetAllArtists();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("artist.csv", true));
            for (Artist s : artists) {
                if(s.getId() == artist.getId()){
                    br.write(artist.getId() + "," +artist.getUsername() + "," + artist.getPassword());
                }
                else{
                    br.write(s.getId() + "," +s.getUsername() + "," + s.getPassword());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void DeleteArtist(Artist artist) {
        List<Artist> artists = GetAllArtists();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("artist.csv", true));
            for (Artist a : artists) {
                if(a.getId() != artist.getId()){
                    bw.write(a.getId() + "," +a.getUsername() + "," + a.getPassword());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Artist> GetAllArtists() {

        List<Artist> artists = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("artist.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                artists.add(new Artist(Integer.parseInt(colonne[0]), colonne[1], colonne[2]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return artists;

    }

    @Override
    public Artist GetArtist(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("artist.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new Artist(id, colonne[1], colonne[2]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
