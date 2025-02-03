package com.example.ironmaiden;


import java.util.Scanner;

public class UserRegisterCSV {


    public UserRegisterCSV() {

    }

    public void registrati(User user) {

        UserDAOImplCSV userCSV = new UserDAOImplCSV();
        userCSV.addUser(user);

    }
}