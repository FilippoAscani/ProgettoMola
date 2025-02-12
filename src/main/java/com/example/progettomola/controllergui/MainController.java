package com.example.progettomola.controllergui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    private Button btnArtist;

    @FXML
    private Button btnSponsor;

    @FXML
    private Button btnUser;


    public void handleUser() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
            Stage stage = (Stage) btnUser.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user login", e);
        }

    }

    public void handleArtist() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-login-view.fxml")));
            Stage stage = (Stage) btnArtist.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata artist login", e);
        }

    }

    public void handleSponsor() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnSponsor.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor login", e);
        }

    }
}

