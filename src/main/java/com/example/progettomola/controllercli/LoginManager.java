package com.example.progettomola.controllercli;


import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Sponsor;
import com.example.progettomola.model.entity.User;
import com.example.progettomola.enumerations.TypesOfLayers;
import com.example.progettomola.enumerations.TypesOfRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class LoginManager {


    LoginManager() {

        //costruttore vuoto

    }

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public void gestore(TypesOfLayers typeLayer, TypesOfRoles typeRole){

        //tupeUser non è una stringa, non si può usare equalsIgnoreCase
        Scanner scanner = new Scanner(System.in);

        switch (typeRole) {



            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case USER:

                //controlla se arrivi da csv o da jdbc
                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc");

                    logger.info("id");
                    int idUser = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String cognomeUser = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordUser = scanner .nextLine();


                    User newU = new User(idUser, cognomeUser, passwordUser);
                    LoginCSV.loginUser(newU);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv");

                    logger.info("id");
                    int idUser = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String cognomeUser = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordUser = scanner .nextLine();

                    User newU = new User(idUser, cognomeUser, passwordUser);
                    LoginCSV.loginUser(newU);

                }



                break;

            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case ARTIST:

                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc da artista");

                    logger.info("id");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String nomeArtist = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordArtist = scanner.nextLine();

                    logger.info("tipo artista");
                    String tipoArtist = scanner.nextLine();

                    Artist newA = new Artist(id, nomeArtist, passwordArtist, tipoArtist);
                    LoginCSV.loginArtist(newA);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv da artista");


                    logger.info("id");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String nomeArtist = scanner.nextLine();

                    logger.info(PASSWORD);
                    String passwordArtist = scanner.nextLine();

                    logger.info("tipo artista");
                    String tipoArtist = scanner.nextLine();

                    Artist newA = new Artist(id, nomeArtist, passwordArtist, tipoArtist);
                    LoginCSV.loginArtist(newA);

                }

                break;


            case SPONSOR:

                if(typeLayer == TypesOfLayers.JDBC ){

                    logger.info("inizializzo la password jdbc da sponsor");

                    logger.info("id");
                    int idSponsor = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String username = scanner.nextLine();

                    logger.info(PASSWORD);
                    String password = scanner.nextLine();


                    Sponsor newS = new Sponsor(idSponsor, username, password);
                    LoginCSV.loginSponsor(newS);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    logger.info("inizializzo la password csv da sponsor");

                    logger.info("id");
                    int idSponsor = scanner.nextInt();
                    scanner.nextLine();

                    logger.info(USERNAME);
                    String username = scanner.nextLine();

                    logger.info(PASSWORD);
                    String password = scanner.nextLine();


                    Sponsor newS = new Sponsor(idSponsor, username, password);
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


