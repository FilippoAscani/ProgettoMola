package com.example.progettomola.ControllerGUI;


import javafx.event.ActionEvent;
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


    public void handleUser(ActionEvent actionEvent) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
            Stage stage = (Stage) btnUser.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void handleArtist(ActionEvent actionEvent) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-login-view.fxml")));
            Stage stage = (Stage) btnArtist.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void handleSponsor(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnSponsor.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

