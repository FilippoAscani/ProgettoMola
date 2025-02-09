package com.example.progettomola.ControllerGUI;

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

public class UserLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblpassword;

    @FXML
    private Label lblusername;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;


    @FXML
    public void handleRegister(ActionEvent ActionEvent) throws IOException {
        //cambia schermata e porta alla registrazione
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register-view.fxml")));
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-homepage-view.fxml")));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));

    }



}
