package com.example.progettomola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class UserLoginDB {

    public UserLoginDB(){

    }

    //ricorda di copiare su questa pagina UserLoginCSV

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
                    RegisterCSV registerCSV = new RegisterCSV();
                    registerCSV.registraUserCSV(user);
                }

                reader.close();
            }


            if (Objects.equals("nome nel file", user.getNome()) && Objects.equals("password nel file", user.getPassword())) {
                doEnter();

            } else {
                RegisterCSV registerCLI = new RegisterCSV();
                registerCLI.registraUserCSV(user);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void doEnter(){
        System.out.println("Benvenuto tra gli Iron Maiden");
    }



}
