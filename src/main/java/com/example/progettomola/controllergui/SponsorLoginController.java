package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.exceptions.DBConnectionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class SponsorLoginController implements Initializable {

    @FXML
    private Button btnIndietro;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private ComboBox<String> combo1;

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

    private static final Logger logger = LoggerFactory.getLogger(SponsorLoginController.class);

    @FXML
    public void select() {
        combo1.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1.setItems(list);

    }

    @FXML
    public void handleIndietro(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata main homepage", e);
        }
    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();
        String s = combo1.getSelectionModel().getSelectedItem();

        switch (s) {
            case "JDBC":
                if(cercaBD(username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non sei iscritto al database, vai su register");
                }
                break;

            case "CSV":
                if(cercaCSV()){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non sei iscritto sul file system vai su register");
                }
                break;

            default:
                    logger.info("errore default file system");

        }

    }

    private boolean cercaBD(String username, String password) {




        String query = "SELECT * FROM sponsors WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException | DBConnectionException e) {
            logger.info("Error during database operation: {}" , e.getMessage());

            return false;
        }
    }


    @FXML
    public void handleRegister(){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-register-view.fxml")));
            Stage stage = (Stage) btnRegister.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor register", e);
        }


    }


    private boolean cercaCSV() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("sponsor.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] dati = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[1].equals(username) && dati[2].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare sponsor csv");
        }
        return trovato;
    }







}


