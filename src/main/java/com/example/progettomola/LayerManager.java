package com.example.ironmaiden;

import java.util.Scanner;

public class LayerManager {

    LayerManager(){

    }

    public void gestore(TypesOfLayers typeLayer, TypesOfRoles typeRole){

        LoginManager loginManager = new LoginManager();
        Scanner scanner = new Scanner(System.in);

        switch (typeLayer){

            //se qui utente ha scelto cli come vista
            case JDBC:

                System.out.println("scegli tra USER, ARTIST, SPONSOR");
                String roleJDBC = scanner.nextLine();
                loginManager.gestore(TypesOfLayers.valueOf(String.valueOf(typeLayer)), TypesOfRoles.valueOf(roleJDBC));

                break;

            case CSV:

                System.out.println("scegli tra USER, ARTIST, SPONSOR");
                String roleCSV = scanner.nextLine();
                loginManager.gestore(TypesOfLayers.valueOf(String.valueOf(typeLayer)), TypesOfRoles.valueOf(roleCSV));

                break;

            default:

                System.out.println("errore");
                break;


        }

        scanner.close();


    }






}
