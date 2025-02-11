package com.example.progettomola.controllergui;

import com.example.progettomola.controllercli.RegisterCSV;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

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

    Logger logger = Logger.getLogger(UserRegisterController.class.getName());

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleRegisterCSV(ActionEvent event) {
        if(cercaCSV()){
            logger.info("utente trovato");
        }
        else{
            Sponsor sponsor = createSponsor();
            RegisterCSV.registraSponsorCSV(sponsor);
        }
    }





    @FXML
    void handleRegisterDB(ActionEvent event) {
        if(cercaDB()){
            logger.info("utente trovato");
        }
        else{
            Sponsor sponsor = createSponsor();
            RegisterCSV.registraSponsorDB(sponsor);
        }
    }


    private Sponsor createSponsor() {
        String usename = usernameField.getText();
        String password = passwordField.getText();
        Random random = new Random();
        int id = random.nextInt(10000);

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
                       return find;

                   }
               }
           } catch (IOException e) {
                e.printStackTrace();
           }
           return find;
    }


    private boolean cercaDB() {
        final String URL = "jdbc:mysql://127.0.0.1:3306/register_schema?useUnicode=true&characterEncoding=utf8";
        final String USERNAME = "root";
        final String PASSWORD = "Filippo98";



        String query = "SELECT * FROM sponsors WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usernameField.getText());
            ps.setString(2, passwordField.getText());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error during database operation: " + e.getMessage());

            return false;
        }
    }

}

