package com.example.progettomola;


import com.example.progettomola.controllercli.ViewManager;
import com.example.progettomola.enumerations.TypesOfViews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {


    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ViewManager viewManager = new ViewManager();

        logger.info("inserisci CLI oppure GUI");
        String view = scanner.nextLine();

        viewManager.gestore(TypesOfViews.valueOf(view));



    }

}

