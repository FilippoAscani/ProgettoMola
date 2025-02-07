package com.example.progettomola;

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
            System.out.println("digita 2 per Cerca Spettacolo");
            System.out.println("digita 3 per Recensioni");
            System.out.println("digita 4 per Uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    System.out.println("ecco il tuo profilo");

                    System.out.println("ID " + user.getId());
                    System.out.println("Nome " + user.getNome());
                    System.out.println("Cognome " + user.getCognome());
                    System.out.println("Password " + user.getPassword());
                    System.out.println("Username " + user.getUsername());
                    System.out.println("\n");

                    System.out.println("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    System.out.println("ecco gli spettacoli");
                    //cerca anche spettacolo()
                    //visualizza csv dell'artistacsv
                    //recensisci artista o spettacolo

                    //mostra tutti gli spettacoli
                    ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
                    showDAO.getShows();

                    //cerca spettacolo
                    System.out.println("cerca spettacolo");
                    String tipo = scanner.nextLine();
                    Show trovatoShow = user.cercaSpettacolo(tipo);

                    System.out.println("scrivi recensione");
                    String content = scanner.nextLine();
                    user.writeReview(content, trovatoShow);

                    //scrivi recensione




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

                    ReviewDAOImplCSV reviewDAO = new ReviewDAOImplCSV();
                    reviewDAO.getReviews();


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
