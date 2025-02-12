package com.example.progettomola.controllercli;

import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Request;
import com.example.progettomola.model.entity.Show;
import com.example.progettomola.model.daoimpl.RequestDAOImplCSV;
import com.example.progettomola.model.daoimpl.ShowDAOImplCSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class ArtistHomepage {


    public ArtistHomepage() {

        //costruttore vuoto
    }

    private static final Logger logger = LoggerFactory.getLogger(ArtistHomepage.class);

    public void welcome(Artist artist){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            logger.info("digita 1 per Profilo");
            logger.info("digita 2 per Richieste ricevute");
            logger.info("digita 3 per Recensioni");
            logger.info("digita 4 per Uscire");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    logger.info("ecco il tuo profilo");

                    logger.info("ID {}" , artist.getId());
                    logger.info("Username {}" , artist.getUsername());
                    logger.info("Password {}" , artist.getPassword());


                    logger.info("attendi...");

                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    logger.info("controlla richieste");

                    List<Request> requests = addRequestsFromCSV(artist.getTipo());

                    checkRequests(requests);

                    break;


                case "3":
                    logger.info("visualizza recensioni");
                    //user scrive recensione su spettacolo qualsiasi
                    //se artista è in quello spettacolo visualizza recensione
                    List<Show> shows = getShowsReviewed(artist.getTipo());
                    for(Show show : shows){
                        logger.info("ID {}" , show.getTitolo());
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

    public List<Request> addRequestsFromCSV(String tipo) {
        RequestDAOImplCSV requestDAO = new RequestDAOImplCSV();
        List<Request> requests = requestDAO.getRequests();

        for(Request request : requests){
            if(request.getTipo().equals(tipo)){
                requests.add(request);
            }
        }
        return requests;
    }

    public List<Show> getShowsReviewed(String tipo){
        ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
        List<Show> shows = showDAO.getShows();
        for(Show s : shows){
            if(s.getTipo().equals(tipo)){
                shows.add(s);
            }
        }
        return shows;
    }

    public void checkRequests(List<Request> requests){

        Scanner scanner = new Scanner(System.in);

        if(requests.isEmpty()){
            logger.info("non hai richieste ricevute\n");
        }
        else {
            //for in un altra parte (?)
            for (Request request : requests) {
                logger.info("richiesta {} " ,request.getId());
                logger.info("nome {}" , request.getNome());
                logger.info("capienza {}" , request.getCapienza());
                logger.info("tipo {}" , request.getTipo());
                logger.info("\n");

                logger.info("accetti la richiesta? (y/n)");

                String risposta = scanner.nextLine().toLowerCase();

                if (risposta.equals("y")) {
                    Show show = new Show(request.getId(),request.getNome(), request.getCapienza(), request.getTipo());

                    ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
                    showDAO.addShow(show);
                    request.setStatus("accepted");


                } else {

                    request.setStatus("denied");
                }
            }

        }
    }



}
