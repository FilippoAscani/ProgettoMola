package com.example.ironmaiden;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    //login diversi per tipi di user diversi USER e DEVELOPER
    //oppure stesso login con due comandi per tipo di User?


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ViewManager viewManager = new ViewManager();

        System.out.println("inserisci CLI oppure GUI");
        String view = scanner.nextLine();

        viewManager.gestore(TypesOfViews.valueOf(view));


        //inserisco cli















    }
}

