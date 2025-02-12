package com.example.progettomola.controllercli;

import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Show;
import com.example.progettomola.model.entity.User;
import com.example.progettomola.model.daoimpl.ReviewDAOImplCSV;
import com.example.progettomola.model.daoimpl.ShowDAOImplCSV;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserHomepage {


    public UserHomepage() {

        //questo rappresenta il costruttore

    }

    private static final Logger logger = LoggerFactory.getLogger(UserHomepage.class);


    public void welcome(User user){



        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {

            logger.info("digita 1 per Profilo");
            logger.info("digita 2 per Cerca Spettacolo");
            logger.info("digita 3 per Recensioni");
            logger.info("digita 4 per Uscire");

            String choice = scanner.nextLine();


            switch (choice) {


                case "1":

                    showProfile(user);

                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break ;


                case "2":
                    logger.info("ecco gli spettacoli");
                    //cerca anche spettacolo()
                    //visualizza csv dell'artistacsv
                    //recensisci artista o spettacolo

                    //mostra tutti gli spettacoli
                    ShowDAOImplCSV showDAO = new ShowDAOImplCSV();
                    showDAO.getShows();

                    //cerca spettacolo
                    logger.info("cerca spettacolo");
                    String tipo = scanner.nextLine();
                    Show trovatoShow = user.cercaSpettacolo(tipo);

                    logger.info("scrivi recensione");
                    String content = scanner.nextLine();
                    user.writeReview(content, trovatoShow);

                    //scrivi recensione


                    String nome = scanner.nextLine();
                    Artist trovatoA = user.cercaArtista(nome);

                    trovaArtist(trovatoA);

                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    break;


                case "3":

                    logger.info("visualizza recensioni");
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

                    logger.info("uscita in corso");
                    running = false;
                    break;

                default:
                    logger.info("errore imprevisto UserHomepage");
                    break;
            }


        }

    }

    private void showProfile(User user){
        logger.info("ecco il tuo profilo");

        logger.info("ID {}", user.getId());
        logger.info("Nome {}", user.getNome());
        logger.info("Cognome {}", user.getCognome());
        logger.info("Password {}", user.getPassword());
        logger.info("Username {}" , user.getUsername());
        logger.info("\n");
        logger.info("attendi...");

    }

    private void trovaArtist(Artist trovatoA){
        if(trovatoA != null) {
            logger.info("artista trovato: {} \n",trovatoA.getUsername());
        }
        else{
            logger.info("artista non trovato\n");
        }
    }







}
