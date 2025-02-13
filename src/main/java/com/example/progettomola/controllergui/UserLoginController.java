package com.example.progettomola.controllergui;


import com.example.progettomola.controllercli.CercaCSV;
import com.example.progettomola.controllercli.CercaDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

import java.util.Objects;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable {

    @FXML
    public Button btnIndietroU;
    @FXML
    private Button btnLoginU;

    @FXML
    private Button btnRegisterU;

    @FXML
    private Label lblLoginU;

    @FXML
    private Label lblpasswordU;

    @FXML
    private Label lblusernameU;

    @FXML
    private PasswordField passwordFieldU;

    @FXML
    private TextField usernameFieldU;

    @FXML
    private ComboBox<String>  combo1U;


    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);


    public void select() {
        combo1U.getSelectionModel().getSelectedItem();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1U.setItems(list);

    }


    @FXML
    public void handleRegister(){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-register-view.fxml")));
            Stage stage = (Stage) btnRegisterU.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user register", e);
        }


    }

    @FXML
    public void handleLogin() throws IOException {

        String username = usernameFieldU.getText();
        String password = passwordFieldU.getText();
        String s = combo1U.getSelectionModel().getSelectedItem();

        switch (s) {
            case "JDBC":

                String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";

                if(CercaDB.cercaU(query, username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginU.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("errore user login db, registrati");
                }
                break;

            case "CSV":
                if(CercaCSV.cercaUser(username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginU.getScene().getWindow();
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
            Stage stage = (Stage) btnIndietroU.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata main homepage", e);
        }
    }


}




