package com.example.progettomola;


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

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();


                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    LoginCSV userLogin = new LoginCSV();
                    userLogin.loginUser(newU);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();

                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    LoginCSV userLogin = new LoginCSV();
                    userLogin.loginUser(newU);

                }



                break;

            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case ARTIST:

                if(typeLayer == TypesOfLayers.JDBC ){

                    System.out.println("inizializzo la password jdbc da artista");

                    System.out.println("nome");
                    String nomeArtist = scanner.nextLine();

                    //System.out.println("tipo");
                    //String tipoArtist = scanner.nextLine();

                    System.out.println("password");
                    String passwordArtist = scanner .nextLine();


                    Artist newA = new Artist(nomeArtist, passwordArtist);
                    LoginCSV artistLogin = new LoginCSV();
                    artistLogin.loginArtist(newA);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv da artista");

                    System.out.println("nome artista");
                    String nomeArtist = scanner.nextLine();

                    //System.out.println("tipo");
                    //String tipoArtist = scanner.nextLine();

                    System.out.println("password artista");
                    String passwordArtist = scanner.nextLine();

                    Artist newA = new Artist(nomeArtist, passwordArtist);
                    LoginCSV artistLogin = new LoginCSV();
                    artistLogin.loginArtist(newA);

                }

                break;


            case SPONSOR:

                if(typeLayer == TypesOfLayers.JDBC ){

                    System.out.println("inizializzo la password jdbc da sponsor");

                    System.out.println("nome");
                    String nomeSponsor = scanner.nextLine();

                    //System.out.println("cognome");
                    //String cognomeUser = scanner.nextLine();

                    System.out.println("id ");
                    int idSponsor = scanner.nextInt();


                    Sponsor newS = new Sponsor(nomeSponsor, idSponsor);
                    LoginCSV sponsorLogin = new LoginCSV();
                    sponsorLogin.loginSponsor(newS);
                }


                if(typeLayer == TypesOfLayers.CSV ){
                    System.out.println("inizializzo la password csv da sponsor");

                    System.out.println("nome");
                    String nomeSponsor = scanner.nextLine();

                    //System.out.println("cognome");
                    //String cognomeUser = scanner.nextLine();

                    System.out.println("id");
                    int idSponsor = scanner.nextInt();


                    Sponsor newS = new Sponsor(nomeSponsor, idSponsor);
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


