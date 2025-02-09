package com.example.progettomola;

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
import java.util.Random;

public class RegisterController {

        @FXML
        private Button btnIndietro;

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

        @FXML
        public void handleIndietro(ActionEvent actionEvent) throws IOException {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
                Stage stage = (Stage) btnIndietro.getScene().getWindow();
                stage.setScene(new Scene(root));
        }

        @FXML
        public void handleRegister(ActionEvent actionEvent) {

                String nome = nomeField.getText();
                String cognome = cognomeField.getText();
                String password = passwordField.getText();
                String username = usernameField.getText();

                userRegister.register(generateId(), nome, cognome, username, password);
        }

        private UserRegister userRegister;

        public RegisterController() {
                userRegister = new UserRegister();
        }

        public int generateId(){
                Random random = new Random();
                return random.nextInt(101);
        }


}


