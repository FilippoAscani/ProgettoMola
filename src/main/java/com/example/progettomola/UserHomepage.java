package com.example.progettomola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserHomepage {

    //private String user;

    public UserHomepage() {
        //this.user = user;

    }

    public void welcome(User user){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("digita 1 per Profilo");
            System.out.println("digita 2 per Cerca");
            System.out.println("digita 3 per Recensioni");
            System.out.println("digita 4 per uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    System.out.println("ecco il tuo profilo");

                    System.out.println("Nome " + user.getNome());
                    System.out.println("Cognome " + user.getCognome());
                    System.out.println("Password " + user.getPassword());
                    //System.out.println("Username\n" + user.getUsername());

                    System.out.println("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    System.out.println("cerca un artista o spettacolo");
                    //cerca anche spettacolo()
                    //visualizza csv dell'artistacsv
                    //recensisci artista o spettacolo

                    String nome = scanner.nextLine();
                    Artist trovatoA = user.cercaArtista(nome);
                    if(trovatoA != null) {
                        System.out.println("artista trovato: " + nome + "\n");
                    }
                    else{
                        System.out.println("artista non trovato\n");
                        break;
                    }



                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;


                case "3":
                    System.out.println("visualizza recensioni");
                    //titoli delle recensioni + descrizione recensione




                    try {
                        TimeUnit.SECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;


                case "4":
                    System.out.println("uscita in corso");
                    System.exit(0);
                    break;

                default:
                    System.out.println("errore imprevisto UserHomepage");
            }

        }

    }



    /*
    due cose possibili o cerco nel file artist.csv
    oppure quando registro artist lo inserisco anche in un array dinamico
    senza cercarlo nel file

    dal momento che il file e' piccolo sti cazzi
    dubbio se inserire cercaArtista direttamente nella classe User
    oppure se inserirlo qua sotto






     */





}
