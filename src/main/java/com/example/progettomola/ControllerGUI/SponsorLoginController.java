package com.example.progettomola.ControllerGUI;

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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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


    @FXML
    public void select(ActionEvent actionEvent) {
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
            throw new RuntimeException(e);
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
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-homepage-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    System.out.println("nonono");
                }
                break;

            case "CSV":
                if(cercaCSV()){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-homepage-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    System.out.println("nonono da csv");
                }
                break;

        }

    }

    private boolean cercaBD(String username, String password) {
        return false;
    }


    @FXML
    public void handleRegister(ActionEvent actionEvent){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-register-view.fxml")));
            Stage stage = (Stage) btnRegister.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new RuntimeException(e);
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
                if (dati[3].equals(username) && dati[4].equals(password)) {
                    trovato = true;
                    return trovato;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trovato;
    }







}


