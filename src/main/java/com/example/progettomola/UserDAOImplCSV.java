package com.example.progettomola;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplCSV implements  UserDAO{


    public UserDAOImplCSV() {

    }


    @Override
    public void addUser(User user) {


        //concetto di BufferedReader per la lettura e scrittura su un file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "user.csv", true));
            bw.write(user.getId() + "," +user.getUsername() + "," + user.getPassword());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void updateUser(User user) {
        List<User> users = getUsers();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("user.csv", true));
            for (User u : users) {
                if(u.getId() == user.getId()){
                    br.write(user.getId() + "," +user.getUsername() + "," + user.getPassword());
                }
                else{
                    br.write(u.getId() + "," +u.getUsername() + "," + u.getPassword());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(User user) {
        List<User> users = getUsers();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("user.csv", true));
            for (User u : users) {
                if(u.getId() != user.getId()){
                    bw.write(u.getId() + "," +u.getUsername() + "," + u.getPassword());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("user.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                users.add(new User(Integer.parseInt(colonne[0]), colonne[1], colonne[2]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;

    }

    @Override
    public User getUser(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("user.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new User(id, colonne[1], colonne[2]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
