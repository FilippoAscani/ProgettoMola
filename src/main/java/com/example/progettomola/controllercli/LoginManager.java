package com.example.progettomola.controllercli;


import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Sponsor;
import com.example.progettomola.model.entity.User;
import com.example.progettomola.enumerations.TypesOfLayers;
import com.example.progettomola.enumerations.TypesOfRoles;

import java.util.Scanner;


public class LoginManager {


    LoginManager() {

    }



    public void gestore(TypesOfLayers typeLayer, TypesOfRoles typeRole){

        //tupeUser non è una stringa, non si può usare equalsIgnoreCase
        Scanner scanner = new Scanner(System.in);

        switch (typeRole) {



            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case USER:

                //controlla se arrivi da csv o da jdbc
                if(typeLayer == TypesOfLayers.JDBC ){

                    System.out.println("inizializzo la password jdbc");

                    System.out.println("id");
                    int idUser = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();


                    User newU = new User(idUser, cognomeUser, passwordUser);
                    LoginCSV.loginUser(newU);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv");

                    System.out.println("id");
                    int idUser = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();

                    User newU = new User(idUser, cognomeUser, passwordUser);
                    LoginCSV.loginUser(newU);

                }



                break;

            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case ARTIST:

                if(typeLayer == TypesOfLayers.JDBC ){

                    System.out.println("inizializzo la password jdbc da artista");

                    System.out.println("id");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username artista");
                    String nomeArtist = scanner.nextLine();

                    System.out.println("password artista");
                    String passwordArtist = scanner.nextLine();

                    System.out.println("tipo artista");
                    String tipoArtist = scanner.nextLine();

                    Artist newA = new Artist(id, nomeArtist, passwordArtist, tipoArtist);
                    LoginCSV.loginArtist(newA);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv da artista");


                    System.out.println("id");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username artista");
                    String nomeArtist = scanner.nextLine();

                    System.out.println("password artista");
                    String passwordArtist = scanner.nextLine();

                    System.out.println("tipo artista");
                    String tipoArtist = scanner.nextLine();

                    Artist newA = new Artist(id, nomeArtist, passwordArtist, tipoArtist);
                    LoginCSV.loginArtist(newA);

                }

                break;


            case SPONSOR:

                if(typeLayer == TypesOfLayers.JDBC ){

                    System.out.println("inizializzo la password jdbc da sponsor");

                    System.out.println("id");
                    int idSponsor = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username");
                    String username = scanner.nextLine();

                    System.out.println("password");
                    String password = scanner.nextLine();


                    Sponsor newS = new Sponsor(idSponsor, username, password);
                    LoginCSV.loginSponsor(newS);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv da sponsor");

                    System.out.println("id");
                    int idSponsor = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("username");
                    String username = scanner.nextLine();

                    System.out.println("password");
                    String password = scanner.nextLine();


                    Sponsor newS = new Sponsor(idSponsor, username, password);
                    LoginCSV.loginSponsor(newS);

                }

                break;



            default:
                System.out.println("errore");
                break;

        }

        scanner.close();


    }





}


