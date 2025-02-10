package com.example.progettomola.ControllerCLI;

import com.example.progettomola.GuiApp;
import com.example.progettomola.Enum.TypesOfLayers;
import com.example.progettomola.Enum.TypesOfViews;

import java.util.Scanner;

public class ViewManager {

    public ViewManager(){

    }

    public void gestore(TypesOfViews typeView){

        LayerManager layerManager = new LayerManager();
        Scanner scanner = new Scanner(System.in);

        switch (typeView){

            case GUI:
                System.out.println("avvio applicazione...");
                GuiApp.main(new String[0]);

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
