package com.example.progettomola;

import java.util.List;

public class UserDAOImplDB implements UserDAO {

    @Override
    public void addUser(User user) {
        System.out.println("aggiunto user a db");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("aggiunto user a db");
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("cancello user da db");
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
