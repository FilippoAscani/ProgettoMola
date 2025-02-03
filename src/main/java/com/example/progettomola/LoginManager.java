package com.example.ironmaiden;


import java.util.Scanner;

import static com.example.ironmaiden.TypesOfLayers.*;


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
                if(typeLayer == JDBC ){

                    System.out.println("inizializzo la password jdbc");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();


                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);
                }


                if(typeLayer == CSV ){
                    System.out.println("inizializzo la password csv");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();

                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);

                }



                break;

            //qui arriviamo da jdbc oppure da csv ma entrambi da cli
            case ARTIST:

                if(typeLayer == JDBC ){

                    System.out.println("inizializzo la password jdbc da artista");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();


                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);
                }


                if(typeLayer == CSV ){
                    System.out.println("inizializzo la password csv da artista");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();

                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);

                }

                break;


            case SPONSOR:

                if(typeLayer == JDBC ){

                    System.out.println("inizializzo la password jdbc da sponsor");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();


                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);
                }


                if(typeLayer == CSV ){
                    System.out.println("inizializzo la password csv da sponsor");

                    System.out.println("nome");
                    String nomeUser = scanner.nextLine();

                    System.out.println("cognome");
                    String cognomeUser = scanner.nextLine();

                    System.out.println("password");
                    String passwordUser = scanner .nextLine();

                    User newU = new User(nomeUser, cognomeUser, passwordUser);
                    UserLoginCSV userLogin = new UserLoginCSV();
                    userLogin.login(newU);

                }

                break;



            default:
                System.out.println("errore");
                break;

        }

        scanner.close();


    }





}


