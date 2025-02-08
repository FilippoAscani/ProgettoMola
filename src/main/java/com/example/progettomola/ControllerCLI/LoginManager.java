package com.example.progettomola.ControllerCLI;


import com.example.progettomola.Model.Entity.Artist;
import com.example.progettomola.Model.Entity.Sponsor;
import com.example.progettomola.Model.Entity.User;
import com.example.progettomola.Enum.TypesOfLayers;
import com.example.progettomola.Enum.TypesOfRoles;

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
                    LoginCSV userLogin = new LoginCSV();
                    userLogin.loginUser(newU);
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
                    LoginCSV userLogin = new LoginCSV();
                    userLogin.loginUser(newU);

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
                    LoginCSV artistLogin = new LoginCSV();
                    artistLogin.loginArtist(newA);
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
                    LoginCSV artistLogin = new LoginCSV();
                    artistLogin.loginArtist(newA);

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
                    LoginCSV sponsorLogin = new LoginCSV();
                    sponsorLogin.loginSponsor(newS);
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
                    LoginCSV sponsorLogin = new LoginCSV();
                    sponsorLogin.loginSponsor(newS);

                }

                break;



            default:
                System.out.println("errore");
                break;

        }

        scanner.close();


    }





}


