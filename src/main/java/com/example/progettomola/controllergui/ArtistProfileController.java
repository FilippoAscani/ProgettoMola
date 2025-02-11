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

public class ArtistProfileController {

    @FXML
    private Button btnElimina;

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnSeeRequests;

    @FXML
    private Button btnSeeReviews;

    @FXML
    private Text txtId;

    @FXML
    private Text txtPassword;

    @FXML
    private Text txtTipo;

    @FXML
    private Text txtUsername;

    @FXML
    private VBox verticalBox;

    @FXML
    void deleteProfile(ActionEvent event) {
        //metodo per tofglierci dal csv e da db
    }

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-login-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSeeRequests(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-request-view.fxml")));
            Stage stage = (Stage) btnSeeRequests.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSeeReviews(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-review-view.fxml")));
            Stage stage = (Stage) btnSeeRequests.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
