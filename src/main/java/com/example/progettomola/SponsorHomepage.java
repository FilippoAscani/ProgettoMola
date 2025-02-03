package com.example.progettomola;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SponsorHomepage {

    //private String user;

    public SponsorHomepage() {
        //this.user = user;

    }

    public void welcome(Sponsor sponsor){

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

                    System.out.println("Nome " + sponsor.getUsername());
                    System.out.println("Cognome " + sponsor.getId());
                    System.out.println("Password " + sponsor.getId());
                    //System.out.println("Username\n" + user.getUsername());

                    System.out.println("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    System.out.println("cerca un artista");
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
