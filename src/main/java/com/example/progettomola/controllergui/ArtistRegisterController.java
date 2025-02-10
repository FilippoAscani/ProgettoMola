package com.example.progettomola.controllergui;

import com.example.progettomola.controllercli.RegisterCSV;
import com.example.progettomola.model.entity.Artist;
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
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

public class ArtistRegisterController {

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
    private Label lblTipo;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField tipoField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    Logger logger = Logger.getLogger(UserRegisterController.class.getName());

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
    void handleRegisterCSV(ActionEvent event) {
        if(cercaCSV()){
            logger.info("utente trovato");
        }
        else{
            Artist artist = createArtist();
            RegisterCSV.registraArtistCSV(artist);
        }
    }




    @FXML
    void handleRegisterDB(ActionEvent event) {
        if(cercaDB()){
            logger.info("utente trovato");
        }
        else{
            Artist artist = createArtist();
            RegisterCSV.registraArtistDB(artist);
        }
    }



    private Artist createArtist() {
        String usename = usernameField.getText();
        String password = passwordField.getText();
        String tipo = tipoField.getText();
        Random random = new Random();
        int id = random.nextInt(10000);

        return new Artist(id, usename, password, tipo);
    }




    private boolean cercaCSV() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String tipo = tipoField.getText();
        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("artist.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] dati = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[1].equals(username) && dati[2].equals(password) && dati[3].equals(tipo)) {

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
        return false;
    }

}
