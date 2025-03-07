package com.example.progettomola.model.dao;

import com.example.progettomola.model.entity.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);  //se mi iscrivo vengo aggiunto agli user
    void updateUser(User user); //se voglio cambiare i miei dati
    void deleteUser(User user); //se voglio disinscrivermi
    User getUser(int id); //se voglio cercare uno specifico user
    List<User> getUsers(); //se voglio tutti gli user

}
