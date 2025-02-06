package com.example.progettomola;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ArtistHomepage {

    public ArtistHomepage() {
        //this.user = user;

    }

    public void welcome(Artist artist){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("digita 1 per Profilo");
            System.out.println("digita 2 per Richieste ricevute");
            System.out.println("digita 3 per Recensioni");
            System.out.println("digita 4 per Uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    System.out.println("ecco il tuo profilo");

                    System.out.println("ID " + artist.getId());
                    System.out.println("Username " + artist.getUsername());
                    System.out.println("Password " + artist.getPassword());


                    System.out.println("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    System.out.println("controlla richieste");
                    //cerca anche spettacolo()
                    //visualizza csv dell'artistacsv
                    //recensisci artista



                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;


                case "3":
                    System.out.println("visualizza recensioni");
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

}
