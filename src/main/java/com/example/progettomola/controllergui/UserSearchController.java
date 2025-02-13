package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.model.entity.Show;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    private static final Logger logger = LoggerFactory.getLogger(UserSearchController.class);


    public void handleCerca() {
        btnCerca.setOnAction(event -> {

            String search = searchField.getText();
            ObservableList<Show> spettacoli = FXCollections.observableArrayList();

            for (Show show : spettacoli) {
                if(show.getTitolo().toLowerCase().contains(search.toLowerCase())){
                   spettacoli.add(show);
                }
            }
            tabView.setItems(spettacoli);
        });

    }

    public void handleIndietro() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user profile", e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.createStatement();

            String sqlQuery = "select id,titolo,capienza,tipo from shows";
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
            logger.info("impossibile cercare show db search controller");
        }



    }
}
