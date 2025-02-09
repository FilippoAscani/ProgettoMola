package com.example.progettomola.ControllerGUI;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.Model.Entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserHomepageController implements Initializable {

        ObservableList<User> utentiTabella = FXCollections.observableArrayList();
        Statement statement = null;
        ResultSet resultSet = null;


        @FXML
        private Button btnCerca;

        @FXML
        private Button btnIndietroHome;

        @FXML
        private TableColumn<User,String> colUtenti;

        @FXML
        private TextField searchField;

        @FXML
        private TableView<User> tabView;




        public void handleCerca() {
                btnCerca.setOnAction(ActionEvent -> {
                        
                        String search = searchField.getText();
                        ObservableList<User> utentiTabellatrovati = FXCollections.observableArrayList();

                        for (User user : utentiTabella) {
                                if(user.getNome().toLowerCase().contains(search.toLowerCase())){
                                        utentiTabellatrovati.add(user);
                                }
                        }
                        tabView.setItems(utentiTabellatrovati);
                });

        }

        public void handleIndietroLogin() throws IOException {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
                Stage stage = (Stage) btnIndietroHome.getScene().getWindow();
                stage.setScene(new Scene(root));
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                try {
                        Connection conn = DatabaseConnection.getConnection();
                        statement = conn.createStatement();

                        String sqlQuery = "select,nome,cognome,username,password from users";
                        resultSet = statement.executeQuery(sqlQuery);

                        while (resultSet.next()) {

                                int id = resultSet.getInt("id");
                                String nome = resultSet.getString("nome");
                                String cognome = resultSet.getString("cognome");
                                String username = resultSet.getString("username");
                                String password = resultSet.getString("password");
                                utentiTabella.add(new User(id, nome, cognome, password,username));
                        }

                        colUtenti.setCellValueFactory(new PropertyValueFactory<>("nome"));
                        tabView.setItems(utentiTabella);

                }
                catch (Exception e) {
                        e.printStackTrace();
                }



        }
}

