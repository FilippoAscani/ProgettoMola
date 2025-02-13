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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class UserLoginController implements Initializable {

    @FXML
    public Button btnIndietro;
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
    private ComboBox<String>  combo1;


    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);


    public void select() {
        combo1.getSelectionModel().getSelectedItem();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1.setItems(list);

    }


    @FXML
    public void handleRegister(ActionEvent actionEvent){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-register-view.fxml")));
            Stage stage = (Stage) btnRegister.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user register", e);
        }


    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();
        String s = combo1.getSelectionModel().getSelectedItem();

        switch (s) {
            case "JDBC":

                String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";

                if(CercaDB.cercaU(query, username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("errore user login db, registrati");
                }
                break;

            case "CSV":
                if(CercaCSV.cercaUser(username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("errore user login csv, registrati");
                }
                break;

            default:
                logger.info("errore user login, registrati");
                break;

        }

    }



    public void handleIndietro() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata main homepage", e);
        }
    }


}




