package com.example.progettomola.controllercli;


import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Sponsor;
import com.example.progettomola.model.entity.User;
import com.example.progettomola.enumerations.TypesOfLayers;
import com.example.progettomola.enumerations.TypesOfRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Scanner;


public class LoginManager {


    LoginManager() {

        //costruttore vuoto

    }

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    SecureRandom rand = new SecureRandom();

    public void gestore(TypesOfLayers typeLayer, TypesOfRoles typeRole){

        //tupeUser non è una stringa, non si può usare equalsIgnoreCase
        Scanner scanner = new Scanner(System.in);

        switch (typeRole) {



            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case USER:

                //controlla se arrivi da csv o da jdbc
                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc");

                    int idU = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String usernameUserDB = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordUserDB = scanner .nextLine();


                    User newU = new User(idU, usernameUserDB, passwordUserDB);
                    LoginCSV.loginUser(newU);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv");

                    int idUser = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String usernameUser = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordUser = scanner .nextLine();

                    User newU = new User(idUser, usernameUser, passwordUser);
                    LoginCSV.loginUser(newU);

                }



                break;

            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case ARTIST:

                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc da artista");

                    int idAdb = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String nomeArtistDB = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordArtistDB = scanner.nextLine();

                    logger.info("tipo artista");
                    String tipoArtistDB = scanner.nextLine();

                    Artist newA = new Artist(idAdb, nomeArtistDB, passwordArtistDB, tipoArtistDB);
                    LoginCSV.loginArtist(newA);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv da artista");


                    int idA = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String nomeArtist = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordArtist = scanner.nextLine();

                    logger.info("tipo artista");
                    String tipoArtist = scanner.nextLine();

                    Artist newA = new Artist(idA, nomeArtist, passwordArtist, tipoArtist);
                    LoginCSV.loginArtist(newA);

                }

                break;


            case SPONSOR:

                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc da sponsor");

                    int idS = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String usernameDB = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordDB = scanner.nextLine();


                    Sponsor newS = new Sponsor(idS, usernameDB, passwordDB);
                    LoginCSV.loginSponsor(newS);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv da sponsor");

                    int idS = this.rand.nextInt(10000);

                    logger.info(USERNAME);
                    String username = scanner.nextLine();

                    logger.info(PASSWORD);
                    String password = scanner.nextLine();


                    Sponsor newS = new Sponsor(idS, username, password);
                    LoginCSV.loginSponsor(newS);

                }

                break;



            default:
                logger.info("errore");
                break;

        }

        scanner.close();


    }










}


