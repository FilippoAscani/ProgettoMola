package com.example.ironmaiden;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class UserLoginDB {

    public UserLoginDB(){

    }


    public void login(User user) {


        try {

            //qui con database
            //sara' la tabella user del database
            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println("User: " + line);
                String[] colonne = line.split(",");
                if (Objects.equals(colonne[0], user.getNome()) &&
                        Objects.equals(colonne[1], user.getCognome()) &&
                        Objects.equals(colonne[2], user.getPassword())){
                    doEnter();
                }
                else {
                    System.out.println("Login failed");
                    UserRegisterCSV userRegisterCSV = new UserRegisterCSV();
                    userRegisterCSV.registrati(user);
                }

                reader.close();
            }


            if (Objects.equals("nome nel file", user.getNome()) && Objects.equals("password nel file", user.getPassword())) {
                doEnter();

            } else {
                UserRegisterCSV userRegisterCLI = new UserRegisterCSV();
                userRegisterCLI.registrati(user);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void doReject(){
        System.out.println("Vai via dagli Iron Maiden");
    }

    public void doEnter(){
        System.out.println("Benvenuto tra gli Iron Maiden");
    }



}
