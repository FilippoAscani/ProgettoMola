package com.example.progettomola;

import com.example.progettomola.Model.DAOImpl.UserDAOImplCSV;
import com.example.progettomola.Model.DAO.UserDAO;
import com.example.progettomola.Model.DAOImpl.UserDAOImplDB;
import com.example.progettomola.Model.Entity.User;


public class UserRegister {

    private final UserDAO userDAOdb;
    private final UserDAO userDAOcli;

    public UserRegister() {
        userDAOdb = new UserDAOImplDB();
        userDAOcli = new UserDAOImplCSV();
    }

    public void registerUdb(int id, String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);

        userDAOdb.addUser(newUser);
        System.out.println("User registered successfully in DB");


    }

    public void registerUcli(int id,String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);
        userDAOcli.addUser(newUser);
        System.out.println("User registered successfully in CSV");
    }

    public void registerAdb(int id, String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);

        userDAOdb.addUser(newUser);
        System.out.println("User registered successfully in DB");


    }

    public void registerAcli(int id,String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);
        userDAOcli.addUser(newUser);
        System.out.println("User registered successfully in CSV");
    }

    public void registerSdb(int id, String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);

        userDAOdb.addUser(newUser);
        System.out.println("User registered successfully in DB");


    }

    public void registerScli(int id,String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);
        userDAOcli.addUser(newUser);
        System.out.println("User registered successfully in CSV");
    }




}
