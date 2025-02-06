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



    user partecipa a show se capienza lo permette
    user scrive recensione se ha partecipato
    user vede profilo
    user cerca spettacolo

    sponsor crea show
    sponsore contatta artisti

    artisti accettano o rifiutano richieste da sponsor
    artisti vedono recensioni che li riguardano
    artisti vedono profilo

    una richiesta dovrebbe apparire cosi
    titolo spettacolo, tipo spettacolo,


     */




}

