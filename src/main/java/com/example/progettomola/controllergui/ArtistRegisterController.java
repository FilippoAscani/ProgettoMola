package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.controllercli.Register;
import com.example.progettomola.exceptions.DBConnectionException;
import com.example.progettomola.model.entity.Artist;
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


public class ArtistRegisterController {

    @FXML
    private Button btnIndietroA;

    @FXML
    private Button btnRegistraA;

    @FXML
    private Button btnRegistra1A;

    @FXML
    private Label lblPasswordA;

    @FXML
    private Label lblRegistrazioneA;

    @FXML
    private Label lblTipoA;

    @FXML
    private Label lblUsernameA;

    @FXML
    private TextField tipoFieldA;

    @FXML
    private PasswordField passwordFieldA;

    @FXML
    private TextField usernameFieldA;

    private static final Logger logger = LoggerFactory.getLogger(ArtistRegisterController.class);
    private final SecureRandom rand = new SecureRandom();

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-login-view.fxml")));
            Stage stage = (Stage) btnIndietroA.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare artist login.", e);
        }
    }

    @FXML
    void handleRegisterCSV(ActionEvent event) {
        if(cercaCSV()){
            logger.info("utente csv trovato");
        }
        else{
            Artist artist = createArtist();
            Register.registraArtistCSV(artist);
        }
    }




    @FXML
    void handleRegisterDB(ActionEvent event) {
        if(cercaDB()){
            logger.info("utente db trovato");
        }
        else{
            Artist artist = createArtist();
            Register.registraArtistDB(artist);
        }
    }



    private Artist createArtist() {
        String usename = usernameFieldA.getText();
        String password = passwordFieldA.getText();
        String tipo = tipoFieldA.getText();

        int id = this.rand.nextInt(10000);

        return new Artist(id, usename, password, tipo);
    }




    private boolean cercaCSV() {
        String username = usernameFieldA.getText();
        String password = passwordFieldA.getText();
        String tipo = tipoFieldA.getText();
        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("artist.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] dati = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[1].equals(username) && dati[2].equals(password) && dati[3].equals(tipo)) {

                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile cercare artista", e);
        }
        return trovato;
    }





    private boolean cercaDB() {




        String query = "SELECT username, password, tipo FROM artists WHERE username = ? AND password = ? AND  tipo = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usernameFieldA.getText());
            ps.setString(2, passwordFieldA.getText());
            ps.setString(3, tipoFieldA.getText());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation: {}" , e.getMessage());

            return false;
        }
    }

}
