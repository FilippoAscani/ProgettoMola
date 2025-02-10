package com.example.progettomola.ControllerGUI;

import com.example.progettomola.ControllerCLI.LoginCSV;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

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


    Logger logger = Logger.getLogger(UserRegisterController.class.getName());

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
        //cerca utente
        if(cercaCSV()){
            logger.info("utente trovato");
        }
        else{
            User user = createUser();
            RegisterCSV.registraUserCSV(user);
        }

    }

    @FXML
    void handleRegisterDB() {
        //cerca utente
        if(cercaDB()){
            logger.info("utente trovato");
        }
        else{
            User user = createUser();
            RegisterCSV.registraUserDB(user);
        }

    }

    private User createUser() {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        Random random = new Random();
        int id = random.nextInt(10000);

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
                    return trovato;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trovato;
    }



    private boolean cercaDB() {

        final String URL = "jdbc:mysql://127.0.0.1:3306/register_schema?useUnicode=true&characterEncoding=utf8";
        final String USERNAME = "root";
        final String PASSWORD = "Filippo98";



        String query = "SELECT * FROM users WHERE nome = ? AND cognome = ? AND  username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nomeField.getText());
            ps.setString(2, cognomeField.getText());
            ps.setString(3, usernameField.getText());
            ps.setString(4, passwordField.getText());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error during database operation: " + e.getMessage());

            return false;
        }

    }









}

