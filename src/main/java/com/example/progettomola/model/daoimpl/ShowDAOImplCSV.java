package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.ShowDAO;
import com.example.progettomola.model.entity.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImplCSV implements ShowDAO {


    private static final String FILE = "show.csv";

    @Override
    public void addShow(Show show) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( FILE, true));
            bw.write(show.getId() + "," +show.getTitolo() + "," + show.getCapienza() + "," + show.getTipo() );
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiungere show", e);
        }


    }

    @Override
    public void updateShow(Show show) {
        List<Show> shows = getShows();
        try {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Show s : shows) {
                    if (s.getId() == show.getId()) {
                        br.write(show.getId() + "," + show.getTitolo() + "," + show.getCapienza() + "," + show.getTipo());
                    } else {
                        br.write(s.getId() + "," + s.getTitolo() + "," + s.getCapienza() + "," + s.getTipo());
                    }
                    br.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiornare show", e);
        }

    }

    @Override
    public void deleteShow(Show show) {
        List<Show> shows = getShows();
        try {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Show s : shows) {
                    if (s.getId() != show.getId()) {
                        bw.write(s.getId() + "," + s.getTitolo() + "," + s.getCapienza() + "," + s.getTipo());
                        bw.newLine();
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile eliminare show", e);
        }
    }

    @Override
    public List<Show> getShows() {

        List<Show> shows = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    shows.add(new Show(Integer.parseInt(colonne[0]), colonne[1], Integer.parseInt(colonne[2]), colonne[3]));

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare shows", e);
        }
        return shows;

    }

    @Override
    public Show getShow(int id) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    if (Integer.parseInt(colonne[0]) == id) {
                        return new Show(id, colonne[1], Integer.parseInt(colonne[2]), colonne[3]);
                    }

                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare show", e);
        }
        return null;
    }
}
