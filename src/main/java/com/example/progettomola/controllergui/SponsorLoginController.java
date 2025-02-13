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
    private Button btnIndietroS;

    @FXML
    private Button btnLoginS;

    @FXML
    private Button btnRegisterS;

    @FXML
    private ComboBox<String> combo1S;

    @FXML
    private Label lblLoginS;

    @FXML
    private Label lblpasswordS;

    @FXML
    private Label lblusernameS;

    @FXML
    private PasswordField passwordFieldS;

    @FXML
    private TextField usernameFieldS;

    private static final Logger logger = LoggerFactory.getLogger(SponsorLoginController.class);

    @FXML
    public void select() {
        combo1S.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1S.setItems(list);

    }

    @FXML
    public void handleIndietro(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietroS.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata main homepage", e);
        }
    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {

        String username = usernameFieldS.getText();
        String password = passwordFieldS.getText();
        String s = combo1S.getSelectionModel().getSelectedItem();

        switch (s) {
            case "JDBC":

                String query = "SELECT username, password FROM sponsors WHERE username = ? AND password = ?";

                if(CercaDB.cercaS(query,username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginS.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non sei iscritto al database, vai su register");
                }
                break;

            case "CSV":
                if(CercaCSV.cercaSponsor(username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginS.getScene().getWindow();
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


    @FXML
    public void handleRegister(){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-register-view.fxml")));
            Stage stage = (Stage) btnRegisterS.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor register", e);
        }


    }


}


