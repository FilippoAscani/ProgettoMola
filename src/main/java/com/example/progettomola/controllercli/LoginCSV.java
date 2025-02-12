package com.example.progettomola.controllercli;

import com.example.progettomola.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Objects;




public class LoginCSV {



    private LoginCSV(){

        /**/

    }


    private static final Logger logger = LoggerFactory.getLogger(LoginCSV.class);


    public static void loginUser(User user) {


        try {

            File file = new File("user.csv");
            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                Register.registraUserCSV(user);
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
                    Register.registraUserCSV(user);
                    doEnterUser(user);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new IllegalStateException("Impossibile fare il loginuser", e);
        }


    }



    public static  void loginArtist(Artist artist) {


        try {

            File file = new File("artist.csv");
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));


            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                Register.registraArtistCSV(artist);
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
                    Register.registraArtistCSV(artist);
                    doEnterArtist(artist);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new IllegalStateException("Impossibile fare il login artist", e);
        }


    }



    public static void loginSponsor(Sponsor sponsor) {


        try {

            File file = new File("sponsor.csv");
            BufferedReader reader = new BufferedReader(new FileReader("sponsor.csv"));




            //inizialmente file vuoto aggiungi
            if (!file.exists() || file.length() == 0) {
                Register.registraSponsorCSV(sponsor);
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
                    Register.registraSponsorCSV(sponsor);
                    doEnterSponsor(sponsor);
                }

            }
            reader.close();

        }

        catch (IOException e) {
            throw new IllegalStateException("Impossibile fare il login sponsor", e);
        }


    }



    public static void doEnterUser(User user){
        logger.info("Benvenuto user {}" , user.getNome());
        UserHomepage userHomepage = new UserHomepage();
        userHomepage.welcome(user);

    }

    public static void doEnterArtist(Artist artist){
        logger.info("Benvenuto artist {}" , artist.getUsername());
        ArtistHomepage artistHomepage = new ArtistHomepage();
        artistHomepage.welcome(artist);

    }

    public static void doEnterSponsor(Sponsor sponsor){
        logger.info("Benvenuto sponsor {}" , sponsor.getUsername());
        SponsorHomepage sponsorHomepage = new SponsorHomepage();
        sponsorHomepage.welcome(sponsor);

    }


}

