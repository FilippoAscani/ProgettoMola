package com.example.progettomola.controllercli;


import com.example.progettomola.model.daoimpl.ArtistDAOImplCSV;
import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Request;
import com.example.progettomola.model.entity.Show;
import com.example.progettomola.model.entity.Sponsor;
import com.example.progettomola.model.daoimpl.ShowDAOImplCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SponsorHomepage {

    // qua non so se inserire private String user

    public SponsorHomepage() {
        // qua non so se inserire questo frammento this.user = user

    }

    public void welcome(Sponsor sponsor){

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
                        Thread.currentThread().interrupt();
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

                    Request request = new Request(id, nomeReq, cap, tipoA);

                    addObserversFromCSV(sponsor,tipoA);

                    sponsor.createRequest(request);

                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;


                case "3":
                    System.out.println("visualizza recensioni");
                    //quelle di spettacoli che hanno le caratteristiche della mia richiesta

                    int c = scanner.nextInt();
                    scanner.nextLine();
                    List<Show> shows = getShowsReviewedCap(c);
                    for (Show show : shows) {
                        System.out.println("ID " + show);
                    }


                    try {
                        TimeUnit.SECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
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


    public void addObserversFromCSV(Sponsor sponsor, String tipo) {
        // Carica gli artisti dal file CSV
        ArtistDAOImplCSV artistDAOImplCSV = new ArtistDAOImplCSV();
        List<Artist> artists = artistDAOImplCSV.getArtists();

        // Aggiungi gli artisti con tipo corrispondente come osservatori
        for (Artist artist : artists) {
            if (artist.getTipo().equals(tipo)) {
                sponsor.addObserver(artist); // Aggiungi l'artista come osservatore
                System.out.println("Artista " + artist.getUsername() + " aggiunto come osservatore");

            }
        }
    }

    public List<Show> getShowsReviewedCap(int cap){
        ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
        List<Show> shows = showDAO.getShows();
        List<Show> result = new ArrayList<>();
        for(Show s : shows){
            if(s.getCapienza() == cap){
                result.add(s);
            }
        }
        return result;
    }




}
