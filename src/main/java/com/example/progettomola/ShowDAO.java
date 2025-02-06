package com.example.progettomola;

import java.util.List;

public interface ShowDAO {

    void addShow(Show show);
    void updateShow(Show show);
    void deleteShow(Show show);
    List<Show> getShows();
    Show getShow(int id);

}
