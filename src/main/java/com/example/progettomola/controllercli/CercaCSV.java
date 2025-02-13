package com.example.progettomola.controllercli;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CercaCSV {

    private CercaCSV(){


    }

    private static final Logger logger = LoggerFactory.getLogger(CercaCSV.class);



    public static boolean cercaUser(String username, String password) {

        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
            String stringa;
            // Leggi il file CSV riga per riga
            while ((stringa = br.readLine()) != null) {
                String[] value = stringa.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (value[1].equals(username) && value[2].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare user csv");
        }
        return trovato;

    }

    public static boolean cercaArtist( String username, String password) {

        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("artist.csv"))) {
            String line;
            // Leggi il file CSV riga per riga
            while ((line = br.readLine()) != null) {
                String[] dati = line.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[1].equals(username) && dati[2].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare artista csv");
        }
        return trovato;


    }

    public static boolean cercaSponsor(String username, String password) {

        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("sponsor.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (data[1].equals(username) && data[2].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare sponsor csv");
        }
        return trovato;

    }





}
