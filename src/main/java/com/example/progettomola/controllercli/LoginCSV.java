package com.example.progettomola.controllercli;

import com.example.progettomola.model.entity.*;

import java.io.*;
import java.util.Objects;




public class LoginCSV {



    public LoginCSV(){

    }



    public static void loginUser(User user) {


        try {

            File file = new File("user.csv");
            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV.registraUserCSV(user);
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
                    RegisterCSV.registraUserCSV(user);
                    doEnterUser(user);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public static  void loginArtist(Artist artist) {


        try {

            File file = new File("artist.csv");
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV.registraArtistCSV(artist);
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
                    RegisterCSV.registraArtistCSV(artist);
                    doEnterArtist(artist);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public static void loginSponsor(Sponsor sponsor) {


        try {

            File file = new File("sponsor.csv");
            BufferedReader reader = new BufferedReader(new FileReader("sponsor.csv"));




            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                RegisterCSV.registraSponsorCSV(sponsor);
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
                    RegisterCSV.registraSponsorCSV(sponsor);
                    doEnterSponsor(sponsor);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public static void doEnterUser(User user){
        System.out.println("Benvenuto " + user.getNome());
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.welcome(user);

    }

    public static void doEnterArtist(Artist artist){
        System.out.println("Benvenuto " + artist.getUsername());
        ArtistHomepage artistHomepage = new ArtistHomepage();
        artistHomepage.welcome(artist);

    }

    public static void doEnterSponsor(Sponsor sponsor){
        System.out.println("Benvenuto " + sponsor.getUsername());
        SponsorHomepage sponsorHomepage = new SponsorHomepage();
        sponsorHomepage.welcome(sponsor);

    }


}

