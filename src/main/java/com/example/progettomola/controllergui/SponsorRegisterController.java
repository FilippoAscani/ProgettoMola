package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.controllercli.Register;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.entity.Sponsor;
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

public class SponsorRegisterController {

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnRegistra;

    @FXML
    private Button btnRegistra1;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblRegistrazione;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private static final Logger logger = LoggerFactory.getLogger(SponsorRegisterController.class);

    private final SecureRandom rand = new SecureRandom();

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor login", e);
        }
    }

    @FXML
    void handleRegisterCSV(ActionEvent event) {
        if(cercaCSV()){
            logger.info("utente csv trovato");
        }
        else{
            Sponsor sponsor = createSponsor();
            Register.registraSponsorCSV(sponsor);
        }
    }





    @FXML
    void handleRegisterDB(ActionEvent event) {
        if(cercaDB()){
            logger.info("utente db trovato");
        }
        else{
            Sponsor sponsor = createSponsor();
            Register.registraSponsorDB(sponsor);
        }
    }


    private Sponsor createSponsor() {
        String usename = usernameField.getText();
        String password = passwordField.getText();

        int id = this.rand.nextInt(10000);

        return new Sponsor(id, usename, password);

    }



    private boolean cercaCSV() {

        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean find = false;

           try (BufferedReader br = new BufferedReader(new FileReader("sponsor.csv"))) {
               String line;
                // Leggi il file CSV riga per riga
               while ((line = br.readLine()) != null) {
                   String[] data = line.split(",");

                    // Se il nome e cognome corrispondono, impostiamo il risultato
                   if (data[1].equals(username) && data[2].equals(password)) {

                       find = true;
                       break;

                   }
               }
           } catch (IOException e) {
               logger.info("impossibile cercare sponsor csv in register controller");
           }
           return find;
    }


    private boolean cercaDB() {



        String query = "SELECT username, password FROM sponsors WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usernameField.getText());
            ps.setString(2, passwordField.getText());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation: {}" , e.getMessage());

            return false;
        }
    }

}

