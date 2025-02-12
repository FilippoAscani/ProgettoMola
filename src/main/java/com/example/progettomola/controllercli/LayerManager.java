package com.example.progettomola.controllercli;

import com.example.progettomola.enumerations.TypesOfLayers;
import com.example.progettomola.enumerations.TypesOfRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LayerManager {

    LayerManager(){

    }

    private static final Logger logger = LoggerFactory.getLogger(LayerManager.class);

    public void gestore(TypesOfLayers typeLayer){

        LoginManager loginManager = new LoginManager();
        Scanner scanner = new Scanner(System.in);

        switch (typeLayer){

            //se qui utente ha scelto cli come vista
            case JDBC:

                logger.info("scegli tra USER, ARTIST, SPONSOR");
                String roleJDBC = scanner.nextLine();
                loginManager.gestore(TypesOfLayers.valueOf(String.valueOf(typeLayer)), TypesOfRoles.valueOf(roleJDBC));

                break;

            case CSV:

                logger.info("scegli tra USER, ARTIST, SPONSOR");
                String roleCSV = scanner.nextLine();
                loginManager.gestore(TypesOfLayers.valueOf(String.valueOf(typeLayer)), TypesOfRoles.valueOf(roleCSV));

                break;

            default:

                logger.info("errore");
                break;


        }

        scanner.close();


    }






}
