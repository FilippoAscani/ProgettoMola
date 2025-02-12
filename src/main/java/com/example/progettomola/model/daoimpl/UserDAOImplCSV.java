package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.UserDAO;
import com.example.progettomola.model.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplCSV implements UserDAO {


    public UserDAOImplCSV() {

        /**/

    }

    private static final String FILE = "user.csv";

    @Override
    public void addUser(User user) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( FILE, true));
            bw.write(user.getId() +
                    "," +user.getNome() +
                    "," + user.getCognome() +
                    ","+ user.getUsername() +
                    "," + user.getPassword());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiungere user", e);
        }



    }

    @Override
    public void updateUser(User user) {
        List<User> users = getUsers();
        try {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE, true))) {
                for (User u : users) {
                    if (u.getId() == user.getId()) {
                        br.write(user.getId() +
                                "," + user.getNome() +
                                "," + user.getCognome() +
                                "," + user.getUsername() +
                                "," + user.getPassword());
                    } else {
                        br.write(u.getId() +
                                "," + u.getNome() +
                                "," + u.getCognome() +
                                "," + u.getUsername() +
                                "," + u.getPassword());
                    }
                    br.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiornare user", e);
        }

    }

    @Override
    public void deleteUser(User user) {
        List<User> users = getUsers();
        try {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                for (User u : users) {
                    if (u.getId() != user.getId()) {
                        bw.write(u.getId() +
                                "," + u.getNome() +
                                "," + u.getCognome() +
                                "," + u.getUsername() +
                                "," + u.getPassword());
                        bw.newLine();
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile eliminare user", e);
        }
    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    users.add(new User(Integer.parseInt(colonne[0]), colonne[1], colonne[2], colonne[3], colonne[4]));

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare users", e);
        }
        return users;

    }

    @Override
    public User getUser(int id) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    if (Integer.parseInt(colonne[0]) == id) {
                        return new User(id, colonne[1], colonne[2], colonne[3], colonne[4]);
                    }

                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare user", e);
        }
        return null;
    }
}
