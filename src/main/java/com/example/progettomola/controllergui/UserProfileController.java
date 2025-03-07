package com.example.progettomola.controllergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UserProfileController {

    @FXML
    private Button btnElimina;

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnReviews;

    @FXML
    private Button btnShow;

    @FXML
    private Text txtCognome;

    @FXML
    private Text txtId;

    @FXML
    private Text txtNome;

    @FXML
    private Text txtPassword;

    @FXML
    private Text txtUsername;


@FXML
    void handleIndietro(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
                Stage stage = (Stage) btnIndietro.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new IllegalStateException("Impossibile caricare la schermata user login", e);
            }

    }

    @FXML
    void handleReviews(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-reviews-view.fxml")));
            Stage stage = (Stage) btnReviews.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user reviews", e);
        }
    }

    @FXML
    void handleShow(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-search-view.fxml")));
            Stage stage = (Stage) btnShow.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user search.", e);
        }
    }

    public void deleteProfile(ActionEvent actionEvent) {
        //delete profile from db and csv
    }
}
