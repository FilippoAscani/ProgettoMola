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

    sponsor fa richiesta di uno spettacolo
    artista se soddisfa richiesta crea spettacolo
    user cerca spettacolo scrive recensione
    recensione appare in artista se ha partecipato
    recensione appare in sponsor se ha organizzato (richiesta == nome show)


     */




}

