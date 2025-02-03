package com.example.progettomola;

import java.util.List;

public interface ArtistDAO {

    void AddArtist(Artist artist); //lo sviluppatore si iscrive(?)
    void UpdateArtist(Artist artist); //lo sviluppatore aggiorna le sua info
    void DeleteArtist(Artist artist); // si disinscrive(?)
    List<Artist> GetAllArtists(); // forse non serve sapere tutti gli sviluppatori
    Artist GetArtist(int id); //forse non serve cercare uno sviluppatore

}
