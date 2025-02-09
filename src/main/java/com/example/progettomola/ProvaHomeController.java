package com.example.progettomola;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class ProvaHomeController {


        @FXML private Button profileButton;
        @FXML private Button searchButton;
        @FXML private Button reviewsButton;
        @FXML private TextField searchField;
        @FXML private Button searchShowButton;
        @FXML private TableView availableShowsTable;
        @FXML private Button participateButton;
        @FXML private TableView userReviewsTable;

        @FXML
        public void initialize() {
            // Aggiungi eventuali listener per i pulsanti, ad esempio:
            searchShowButton.setOnAction(e -> searchShows());
            participateButton.setOnAction(e -> participateInShow());
        }

        private void searchShows() {
            String searchTerm = searchField.getText();
            // Implementa la logica di ricerca spettacoli (ad esempio, query al DB)
            System.out.println("Cercando spettacolo: " + searchTerm);
        }

        private void participateInShow() {
            // Logica per partecipare allo spettacolo (prenotazione)
            System.out.println("Partecipando allo spettacolo...");
        }
    }

