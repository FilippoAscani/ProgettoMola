package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.controllercli.CercaCSV;
import com.example.progettomola.controllercli.CercaDB;
import com.example.progettomola.exceptions.DBConnectionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class ArtistLoginController implements Initializable {

    @FXML
    private Button btnIndietroA;

    @FXML
    private Button btnLoginA;

    @FXML
    private Button btnRegisterA;

    @FXML
    private ComboBox<String> combo1A;

    @FXML
    private Label lblLoginA;

    @FXML
    private Label lblpasswordA;

    @FXML
    private Label lblusernameA;

    @FXML
    private PasswordField passwordFieldA;

    @FXML
    private TextField usernameFieldA;

    private static final Logger logger = LoggerFactory.getLogger(ArtistLoginController.class);

    @FXML
    public void select(ActionEvent actionEvent) {
        combo1A.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1A.setItems(list);

    }

    @FXML
    public void handleIndietro(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietroA.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata di registrazione.", e);
        }
    }

    @FXML
    public void handleLogin() throws IOException {


        String s = combo1A.getSelectionModel().getSelectedItem();
        String username = usernameFieldA.getText();
        String password = passwordFieldA.getText();



        switch (s) {
            case "JDBC":



                String query = "SELECT username, password FROM artists WHERE username = ? AND password = ?";

                if(CercaDB.cercaA(query,username,password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginA.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non è possibile loggare l'artista");
                }
                break;

            case "CSV":
                if(CercaCSV.cercaArtist(username,password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginA.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non è possibile  loggare l'artista csv");
                }
                break;

            default:
                logger.info("errore default");

        }

    }




    @FXML
    public void handleRegister(ActionEvent actionEvent){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-register-view.fxml")));
            Stage stage = (Stage) btnRegisterA.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata di registrazione.", e);
        }


    }







}


