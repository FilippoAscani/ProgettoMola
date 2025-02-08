package com.example.progettomola.Model.DAOImpl;

import com.example.progettomola.Model.DAO.ShowDAO;
import com.example.progettomola.Model.Entity.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImplCSV implements ShowDAO {

    @Override
    public void addShow(Show show) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "show.csv", true));
            bw.write(show.getId() + "," +show.getTitolo() + "," + show.getCapienza() + "," + show.getTipo() );
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateShow(Show show) {
        List<Show> shows = getShows();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("show.csv", true));
            for (Show s : shows) {
                if(s.getId() == show.getId()){
                    br.write(show.getId() + "," +show.getTitolo() + "," + show.getCapienza() + "," + show.getTipo());
                }
                else{
                    br.write(s.getId() + "," +s.getTitolo() + "," + s.getCapienza() + "," + s.getTipo());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteShow(Show show) {
        List<Show> shows = getShows();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("show.csv", true));
            for (Show s : shows) {
                if(s.getId() != show.getId()){
                    bw.write(s.getId() + "," +s.getTitolo() + "," + s.getCapienza() + "," + s.getTipo());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Show> getShows() {

        List<Show> shows = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("show.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                shows.add(new Show(Integer.parseInt(colonne[0]), colonne[1], Integer.parseInt(colonne[2]), colonne[3]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return shows;

    }

    @Override
    public Show getShow(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("show.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new Show(id, colonne[1], Integer.parseInt(colonne[2]), colonne[3]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
