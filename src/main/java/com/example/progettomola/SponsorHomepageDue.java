package com.example.progettomola;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SponsorHomepageDue {

    //private String user;

    public SponsorHomepageDue() {
        //this.user = user;

    }

    public void welcome(Sponsor sponsor, Artist artist){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("digita 1 per Profilo");
            System.out.println("digita 2 per Contatta artista");
            System.out.println("digita 3 per Vedi Recensioni");
            System.out.println("digita 4 per uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    System.out.println("ecco il tuo profilo");

                    System.out.println("ID " + sponsor.getId());
                    System.out.println("Username " + sponsor.getUsername());
                    System.out.println("Password " + sponsor.getPassword());


                    System.out.println("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    System.out.println("invia richieste");

                    System.out.println("inserire id richiesta");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("inserire nome titolo show");
                    String nomeReq = scanner.nextLine();

                    System.out.println("inserire capienza");
                    int cap = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("inserire tipo di artista richiesto");
                    String tipoA = scanner.nextLine();

                    sponsor.addObserver(artist);

                    Request request = new Request(id, nomeReq, cap, tipoA);
                    sponsor.createRequest(request);

                    //un metodo che ha come input



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

