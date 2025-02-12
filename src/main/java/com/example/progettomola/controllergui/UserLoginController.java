package com.example.progettomola.controllergui;

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


    public void select(ActionEvent actionEvent) {
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
                if(cercaDB(username, password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("errore user login db, registrati");
                }
                break;

            case "CSV":
                if(cercaCSV()){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("errore user login csv, registrati");
                }
                break;

        }

    }



    public void handleIndietro(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean cercaDB(String username, String password) {

         final String URL = "jdbc:mysql://127.0.0.1:3306/register_schema?useUnicode=true&characterEncoding=utf8";
         final String USERNAME = "root";
         final String PASSWORD = "Filippo98";



        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
        } catch (SQLException e) {
            logger.info("Error during database operation: {}" , e.getMessage());

                return false;
        }

    }



    private boolean cercaCSV() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean trovato = false;

        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
            String linea;
            // Leggi il file CSV riga per riga
            while ((linea = br.readLine()) != null) {
                String[] dati = linea.split(",");

                // Se il nome e cognome corrispondono, impostiamo il risultato
                if (dati[3].equals(username) && dati[4].equals(password)) {
                    trovato = true;
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trovato;
    }
}




