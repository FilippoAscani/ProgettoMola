package com.example.progettomola.ControllerCLI;

import com.example.progettomola.Model.Entity.Artist;
import com.example.progettomola.Model.Entity.Request;
import com.example.progettomola.Model.Entity.Show;
import com.example.progettomola.Model.DAOImpl.RequestDAOImplCSV;
import com.example.progettomola.Model.DAOImpl.ShowDAOImplCSV;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ArtistHomepage {

    Logger logger = Logger.getLogger("ArtistHomepage");


    public ArtistHomepage() {


    }

    public void welcome(Artist artist){

        Scanner scanner = new Scanner(System.in);

        while(true) {

            logger.info("digita 1 per Profilo");
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

                    List<Request> requests = addRequestsFromCSV(artist.getTipo());

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
                                Show show = new Show(request.getId(),request.getNome(), request.getCapienza(), request.getTipo());

                                ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
                                showDAO.addShow(show);
                                request.setStatus("accepted");


                            } else {

                                request.setStatus("denied");
                            }
                        }

                    }

                    break;


                case "3":
                    System.out.println("visualizza recensioni");
                    //user scrive recensione su spettacolo qualsiasi
                    //se artista è in quello spettacolo visualizza recensione
                    List<Show> shows = getShowsReviewed(artist.getTipo());
                    for(Show show : shows){
                        System.out.println("ID " + show.getTitolo());
                    }




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


}
