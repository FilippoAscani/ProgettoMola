package com.example.progettomola.Model.DAOImpl;

import com.example.progettomola.Model.DAO.ArtistDAO;
import com.example.progettomola.Model.Entity.Artist;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImplCSV implements ArtistDAO {


    public ArtistDAOImplCSV() {

    }



    @Override
    public void addArtist(Artist artist) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "artist.csv", true));
            bw.write(artist.getId()+","+artist.getUsername() +","+ artist.getPassword()+","+ artist.getTipo());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void updateArtist(Artist artist) {
        List<Artist> artists = getArtists();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("artist.csv", true));
            for (Artist a : artists) {
                if(a.getId() == artist.getId()){
                    br.write(artist.getId() + "," +artist.getUsername() + "," + artist.getPassword() + "," + artist.getTipo());
                }
                else{
                    br.write(a.getId() + "," +a.getUsername() + "," + a.getPassword() + "," + a.getTipo());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteArtist(Artist artist) {
        List<Artist> artists = getArtists();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("artist.csv", true));
            for (Artist a : artists) {
                if(a.getId() != artist.getId()){
                    bw.write(a.getId() + "," +a.getUsername() + "," + a.getPassword() + "," + a.getTipo());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Artist> getArtists() {

        List<Artist> artists = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("artist.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                artists.add(new Artist(Integer.parseInt(colonne[0]), colonne[1], colonne[2],colonne[3]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return artists;

    }

    @Override
    public Artist getArtist(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("artist.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new Artist(id, colonne[1], colonne[2],colonne[3]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
