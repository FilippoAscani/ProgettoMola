package com.example.progettomola;

import java.util.Scanner;

public class ViewManager {

    ViewManager(){

    }

    public void gestore(TypesOfViews typeView){

        LayerManager layerManager = new LayerManager();
        Scanner scanner = new Scanner(System.in);

        switch (typeView){

            case GUI:
                System.out.println("avvio applicazione...");
                //avvia finestra che chiede db o csv,
                //entrambe alla finestra seleziona utente,sponsor o artista
                //se utente -> homepageutente...

                break;

            case CLI:

                System.out.println("inserisci JDBC oppure CSV");
                String layer = scanner.nextLine();

                layerManager.gestore(TypesOfLayers.valueOf(layer));

                break;

            default:
                System.out.println("errore");
                break;

        }

        scanner.close();


    }

}
