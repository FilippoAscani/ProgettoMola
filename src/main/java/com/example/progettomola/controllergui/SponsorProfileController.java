package com.example.progettomola.controllergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SponsorProfileController {

    @FXML
    private Button btnCreaRichieste;

    @FXML
    private Button btnElimina;

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnRecensioni;

    @FXML
    private Text txtId;

    @FXML
    private Text txtPassword;

    @FXML
    private Text txtUsername;

    @FXML
    private VBox verticalBox;

    @FXML
    void deleteProfile(ActionEvent event) {
     //da aggiungere se c'è tempo
    }

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare sponsor login", e);
        }
    }

    @FXML
    void handleRequests(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-request-view.fxml")));
            Stage stage = (Stage) btnCreaRichieste.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor request", e);
        }
    }

    @FXML
    void handleReviews(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-review-view.fxml")));
            Stage stage = (Stage) btnRecensioni.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor review", e);
        }
    }

}

