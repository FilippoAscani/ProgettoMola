package com.example.progettomola.controllergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    void handleElimina(ActionEvent event) {

    }

    @FXML
    void handleIndietro(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
                Stage stage = (Stage) btnIndietro.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    @FXML
    void handleReviews(ActionEvent event) {

    }

    @FXML
    void handleShow(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-search-view.fxml")));
            Stage stage = (Stage) btnShow.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
