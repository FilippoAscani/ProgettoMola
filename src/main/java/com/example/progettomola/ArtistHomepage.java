package com.example.progettomola;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ArtistHomepage {



    public ArtistHomepage() {


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

                    List<Request> requests = artist.getRequests();

                    if(requests.isEmpty()){
                        System.out.println("non hai richieste ricevute\n");
                    }
                    else {
                        //for in un altra parte (?)
                        for (Request request : requests) {
                            System.out.println("richiesta " + request.getId() + ":");
                            System.out.println("nome: " + request.getNome());
                            System.out.println("capienza " + request.getCapienza());
                            System.out.println("tipo " + request.getTipo());
                            System.out.println();

                            System.out.println("accetti la richiesta? (y/n)");

                            String risposta = scanner.nextLine().toLowerCase();

                            if (risposta.equals("y")) {
                                artist.acceptRequest(request);
                            } else {
                                artist.declineRequest(request);
                            }
                        }

                    }

                    break;


                case "3":
                    System.out.println("visualizza recensioni");
                    //user scrive recensione su spettacolo qualsiasi
                    //se artista è in quello spettacolo visualizza recensione


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
