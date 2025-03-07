package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.controllercli.Register;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.entity.User;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Objects;

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


    private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);
    private final SecureRandom rand = new SecureRandom();

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
    void handleRegisterCSV() {
        if(cercaCSV()){
            logger.info("utente csv trovato");
        }
        else{
            User user = createUser();
            Register.registraUserCSV(user);
        }

    }

    @FXML
    void handleRegisterDB() {
        //cerca utente
        if(cercaDB()){
            logger.info("utente db trovato");
        }
        else{
            User user = createUser();
            Register.registraUserDB(user);
        }

    }

    private User createUser() {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();


        int id = this.rand.nextInt(10000);

        return new User(id, nome, cognome, username, password);
    }


    private boolean cercaCSV() {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] dati = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[1].equals(nome) &&
                        dati[2].equals(cognome)
                        && dati[3].equals(username)
                        && dati[4].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare user csv register controller");
        }
        return trovato;
    }



    private boolean cercaDB() {





        String query = "SELECT nome, cognome, username, password FROM users WHERE nome = ? AND cognome = ? AND  username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nomeField.getText());
            ps.setString(2, cognomeField.getText());
            ps.setString(3, usernameField.getText());
            ps.setString(4, passwordField.getText());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation: {}" , e.getMessage());

            return false;
        }

    }









}

