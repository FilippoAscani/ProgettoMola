package com.example.progettomola.controllergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SponsorRequestController {

    @FXML
    private Button btnCrea;

    @FXML
    private Button btnIndietro;

    @FXML
    private TextField txtCapienza;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtTitolo;

    @FXML
    void handleCrea(ActionEvent event) {

    }

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

