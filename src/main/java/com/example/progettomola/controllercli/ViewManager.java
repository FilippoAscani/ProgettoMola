package com.example.progettomola.controllercli;

import com.example.progettomola.GuiApp;
import com.example.progettomola.enumerations.TypesOfLayers;
import com.example.progettomola.enumerations.TypesOfViews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ViewManager {

    public ViewManager(){
    /**/

    }


    private static final Logger logger = LoggerFactory.getLogger(ViewManager.class);


    public void gestore(TypesOfViews typeView){

        LayerManager layerManager = new LayerManager();
        Scanner scanner = new Scanner(System.in);

        switch (typeView){

            case GUI:
                logger.info("avvio applicazione...");
                GuiApp.main(new String[0]);

                break;

            case CLI:

                logger.info("inserisci JDBC oppure CSV");
                String layer = scanner.nextLine();

                layerManager.gestore(TypesOfLayers.valueOf(layer));

                break;

            default:
                logger.info("errore");
                break;

        }

        scanner.close();


    }




}
