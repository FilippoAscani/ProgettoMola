package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.model.entity.Show;
import com.example.progettomola.model.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class UserSearchController implements Initializable {

    ObservableList<Show> spettacoliTrovati = FXCollections.observableArrayList();
    Statement statement = null;
    ResultSet resultSet = null;


    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIndietro;

    @FXML
    private TableColumn<Show,String> colShows;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Show> tabView;




    public void handleCerca() {
        btnCerca.setOnAction(ActionEvent -> {

            String search = searchField.getText();
            ObservableList<Show> spettacoliTrovati = FXCollections.observableArrayList();

            for (Show show : spettacoliTrovati) {
                if(show.getTitolo().toLowerCase().contains(search.toLowerCase())){
                   spettacoliTrovati.add(show);
                }
            }
            tabView.setItems(spettacoliTrovati);
        });

    }

    public void handleIndietro() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
        Stage stage = (Stage) btnIndietro.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            statement = conn.createStatement();

            String sqlQuery = "select,id,titolo,capienza,tipo from shows";
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String titolo = resultSet.getString("titolo");
                int capienza = resultSet.getInt("capienza");
                String tipo = resultSet.getString("tipo");

                spettacoliTrovati.add(new Show(id, titolo, capienza, tipo));
            }

            colShows.setCellValueFactory(new PropertyValueFactory<>("titolo"));
            tabView.setItems(spettacoliTrovati);

        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
