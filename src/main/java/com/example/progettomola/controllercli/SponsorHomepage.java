package com.example.progettomola.controllercli;


import com.example.progettomola.model.daoimpl.ArtistDAOImplCSV;
import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Request;
import com.example.progettomola.model.entity.Show;
import com.example.progettomola.model.entity.Sponsor;
import com.example.progettomola.model.daoimpl.ShowDAOImplCSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SponsorHomepage {

    // qua non so se inserire private String user

    public SponsorHomepage() {
        // qua non so se inserire questo frammento this.user = user

    }

    private static final Logger logger = LoggerFactory.getLogger(SponsorHomepage.class);

    public void welcome(Sponsor sponsor){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            logger.info("digita 1 per Profilo");
            logger.info("digita 2 per Contatta artista");
            logger.info("digita 3 per Vedi Recensioni");
            logger.info("digita 4 per uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    logger.info("ecco il tuo profilo");

                    logger.info("ID {}" , sponsor.getId());
                    logger.info("Username {}" , sponsor.getUsername());
                    logger.info("Password {}" , sponsor.getPassword());


                    logger.info("attendi...");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break ;


                case "2":
                    logger.info("invia richieste");

                    logger.info("inserire id richiesta");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    logger.info("inserire nome titolo show");
                    String nomeReq = scanner.nextLine();

                    logger.info("inserire capienza");
                    int cap = scanner.nextInt();
                    scanner.nextLine();

                    logger.info("inserire tipo di artista richiesto");
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
                    logger.info("visualizza recensioni");
                    //quelle di spettacoli che hanno le caratteristiche della mia richiesta

                    int c = scanner.nextInt();
                    scanner.nextLine();
                    List<Show> shows = getShowsReviewedCap(c);
                    for (Show show : shows) {
                        logger.info("ID {}" , show);
                    }


                    try {
                        TimeUnit.SECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;


                case "4":
                    logger.info("uscita in corso");
                    System.exit(0);
                    break;

                default:
                    logger.info("errore imprevisto UserHomepage");
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
                logger.info("Artista {} aggiunto come osservatore" , artist.getUsername());

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
