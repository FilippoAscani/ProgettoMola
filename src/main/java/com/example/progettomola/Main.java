package com.example.progettomola;


import com.example.progettomola.ControllerCLI.ViewManager;
import com.example.progettomola.Enum.TypesOfViews;

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

}

