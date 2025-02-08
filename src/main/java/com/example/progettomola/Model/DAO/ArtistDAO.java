package com.example.progettomola.Model.DAO;

import com.example.progettomola.Model.Entity.Artist;

import java.util.List;

public interface ArtistDAO {

    void addArtist(Artist artist); //lo sviluppatore si iscrive(?)
    void updateArtist(Artist artist); //lo sviluppatore aggiorna le sua info
    void deleteArtist(Artist artist); // si disinscrive(?)
    List<Artist> getArtists(); // forse non serve sapere tutti gli sviluppatori
    Artist getArtist(int id); //forse non serve cercare uno sviluppatore

}
