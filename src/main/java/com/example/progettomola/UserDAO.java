package com.example.ironmaiden;

import java.util.List;

public interface UserDAO {

    void addUser(User user);  //se mi iscrivo vengo aggiunto agli user
    void updateUser(User user); //se voglio cambiare i miei dati
    void deleteUser(int id); //se voglio disinscrivermi
    User getUser(int id); //se voglio cercare uno specifico user
    List<User> getUsers(); //se voglio tutti gli user

}
