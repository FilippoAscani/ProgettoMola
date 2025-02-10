package com.example.progettomola.ControllerGUI;

import com.example.progettomola.ControllerCLI.RegisterCSV;
import com.example.progettomola.Model.Entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class UserRegisterController {

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnRegistra;

    @FXML
    private Button btnRegistra1;

    @FXML
    private TextField cognomeField;

    @FXML
    private Label lblCognome;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblRegistrazione;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField nomeField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;




    String nome = nomeField.getText();
    String cognome = cognomeField.getText();
    String username = usernameField.getText();
    String password = passwordField.getText();
    int id = Integer.parseInt(UUID.randomUUID().toString());

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
    void handleRegisterCSV() {

        User newUser = new User(id,nome, cognome, username, password);
        RegisterCSV.registraUserCSV(newUser);

    }

    @FXML
    void handleRegisterDB() {

        User newUserDB = new User(id,nome, cognome, username, password);
        RegisterCSV.registraUserDB(newUserDB);
    }

}

