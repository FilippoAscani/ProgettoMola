package com.example.progettomola;

import com.example.progettomola.Model.DAOImpl.UserDAOImplCSV;
import com.example.progettomola.Model.DAO.UserDAO;
import com.example.progettomola.Model.DAOImpl.UserDAOImplDB;
import com.example.progettomola.Model.Entity.User;


import java.util.List;

public class UserRegister {

    private final UserDAO userDAO;
    private final UserDAO userDAOcli;

    public UserRegister() {
        userDAO = new UserDAOImplDB();
        userDAOcli = new UserDAOImplCSV();
    }

    public void register(int id, String nome, String cognome, String password, String username) {
        User newUser = new User(id, nome, cognome, password, username);

        userDAO.addUser(newUser);
        System.out.println("User registered successfully in DB");

        userDAOcli.addUser(newUser);
        System.out.println("User registered successfully in CSV");

    }

    public List<User> getAllRegisteredUsers() {
        return userDAO.getUsers();
    }
}
