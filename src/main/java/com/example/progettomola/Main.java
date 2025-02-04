package com.example.progettomola;


import java.util.Scanner;

public class Main {


    //login diversi per tipi di user diversi USER e ARTIST
    //oppure stesso login con due comandi per tipo di User?


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ViewManager viewManager = new ViewManager();

        System.out.println("inserisci CLI oppure GUI");
        String view = scanner.nextLine();

        viewManager.gestore(TypesOfViews.valueOf(view));



    }

    /*
    user
    cerca spettacolo
    scrive recensione
    visualizza proprio profilo
    vede recensioni che ha scritto


    artista
    visualizza profilo
    risponde a richieste di sponsor
    vede le recensioni degli spettacoli dove presente

    sponsor
    crea eventi con spettacoli
    invia richieste a artisti
    altra funzione oppure no


     */




}

