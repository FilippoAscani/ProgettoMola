package com.example.progettomola;

import java.util.List;

public interface DeveloperDAO {

    void AddDeveloper(Sponsor developer); //lo sviluppatore si iscrive(?)
    void UpdateDeveloper(Sponsor developer); //lo sviluppatore aggiorna le sua info
    void DeleteDeveloper(Sponsor developer); // si disinscrive(?)
    List<Sponsor> GetAllDevelopers(); // forse non serve sapere tutti gli sviluppatori
    Sponsor GetDeveloper(int id); //forse non serve cercare uno sviluppatore

}
