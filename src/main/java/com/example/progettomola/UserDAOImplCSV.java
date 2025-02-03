package com.example.ironmaiden;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserDAOImplCSV implements  UserDAO{


    public UserDAOImplCSV() {

    }


    @Override
    public void addUser(User user) {

        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "user.csv"));
            bw.write(user.getNome() +","+ user.getCognome() + "," + user.getPassword());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }
}
