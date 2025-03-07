package com.example.progettomola.controllergui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ArtistReviewController {

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIndietro;

    @FXML
    private TableColumn<?, ?> colReviews;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<?> tabView;



    @FXML
    void handleCerca() {
        //metodo che deve essere implementato
    }

    @FXML
    void handleIndietro() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata artist profile.", e);
        }
    }

}
