package com.example.progettomola.ControllerCLI;

import com.example.progettomola.Model.Entity.*;

import java.io.*;
import java.util.Objects;




public class LoginCSV {



    public LoginCSV(){

    }



    public void loginUser(User user) {


        try {

            File file = new File("user.csv");
            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV userCSV = new RegisterCSV();
                userCSV.registraUserCSV(user);
                doEnterUser(user);
            }

            else{

                boolean isFind = false;
                String linetwo;
                while((linetwo = reader.readLine()) != null) {

                    String[] colonnetwo = linetwo.split(",");
                    if (Objects.equals(colonnetwo[0], user.getNome())
                            && Objects.equals(colonnetwo[1], user.getCognome())
                            && Objects.equals(colonnetwo[2], user.getPassword())) {
                        isFind = true;
                        doEnterUser(user);
                    }
                }

                if(!isFind) {
                    RegisterCSV userCSV = new RegisterCSV();
                    userCSV.registraUserCSV(user);
                    doEnterUser(user);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public void loginArtist(Artist artist) {


        try {

            File file = new File("artist.csv");
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV UserCSV = new RegisterCSV();
                UserCSV.registraArtist(artist);
                doEnterArtist(artist);
            }

            else{

                boolean isFind = false;
                String linetwo;
                while((linetwo = reader.readLine()) != null) {

                    String[] colonnetwo = linetwo.split(",");
                    if (Objects.equals(colonnetwo[0], artist.getUsername())
                            && Objects.equals(colonnetwo[1], artist.getTipo())
                            && Objects.equals(colonnetwo[2], artist.getPassword())) {
                        isFind = true;
                        doEnterArtist(artist);
                    }
                }

                if(!isFind) {
                    RegisterCSV UserCSV = new RegisterCSV();
                    UserCSV.registraArtist(artist);
                    doEnterArtist(artist);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public void loginSponsor(Sponsor sponsor) {


        try {

            File file = new File("sponsor.csv");
            BufferedReader reader = new BufferedReader(new FileReader("sponsor.csv"));




            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV UserCSV = new RegisterCSV();
                UserCSV.registraSponsor(sponsor);
                doEnterSponsor(sponsor);
            }

            else{

                boolean isFind = false;
                String linetwo;
                while((linetwo = reader.readLine()) != null) {

                    String[] colonnetwo = linetwo.split(",");
                    if (Objects.equals(colonnetwo[0], sponsor.getUsername())
                            && Objects.equals(colonnetwo[1], String.valueOf(sponsor.getId()))
                            && Objects.equals(colonnetwo[2], String.valueOf(sponsor.getId()))) {
                        isFind = true;
                        //probabile caricamento o apertura delle richieste
                        //probabile recensioni
                        doEnterSponsor(sponsor);
                    }
                }

                if(!isFind) {
                    RegisterCSV UserCSV = new RegisterCSV();
                    UserCSV.registraSponsor(sponsor);
                    doEnterSponsor(sponsor);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }











    public void doEnterUser(User user){
        System.out.println("Benvenuto " + user.getNome());
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.welcome(user);

    }

    public void doEnterArtist(Artist artist){
        System.out.println("Benvenuto " + artist.getUsername());
        ArtistHomepage artistHomepage = new ArtistHomepage();
        artistHomepage.welcome(artist);

    }

    public void doEnterSponsor(Sponsor sponsor){
        System.out.println("Benvenuto " + sponsor.getUsername());
        SponsorHomepage sponsorHomepage = new SponsorHomepage();
        sponsorHomepage.welcome(sponsor);

    }


}









/*
file vuoto -> inserisce utente ed esci
file non vuoto -> cerca -> trova -> esci
                        -> non trova -> inserisci -> esci




String line = reader.readLine();
            String[] colonne = line.split(",");
            if (Objects.equals(colonne[0], user.getNome())
                    && Objects.equals(colonne[1], user.getCognome())
                    && Objects.equals(colonne[2], user.getPassword())) {
                System.out.println(colonne[0] + " " + colonne[1] + " " + colonne[2]);

            }

 */

















