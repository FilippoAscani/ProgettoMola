package com.example.progettomola.ControllerGUI;

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

import java.io.IOException;
import java.net.URL;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1.setItems(list);

    }


    @FXML
    public void handleRegister(ActionEvent actionEvent)  throws IOException {
        //cambia schermata e porta alla registrazione
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register-view.fxml")));
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    public void handleLogin(ActionEvent actionEvent) throws IOException {

        //controlla csv o database
        String s = combo1.getSelectionModel().getSelectedItem();

        if(s.equals("JDBC")){
            //cerca user nel db
            lblLogin.setVisible(false);
        }
        if (s.equals("CSV")){
            //cerca user nel db
            lblLogin.setVisible(true);
        }

        //manda in homepage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-homepage-view.fxml")));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));

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


}
