package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.model.entity.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class ArtistRequestController  implements Initializable {

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIndietro;

    @FXML
    private TableColumn<Request, String> colRequests;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Request> tabView;



    ObservableList<Request> richieste = FXCollections.observableArrayList();
    Statement statement = null;
    ResultSet resultSet = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            statement = conn.createStatement();

            String sqlQuery = "SELECT id, nome, capienza, tipo FROM requests";
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titolo = resultSet.getString("nome");
                int capienza = resultSet.getInt("capienza");
                String tipo = resultSet.getString("tipo");

                richieste.add(new Request(id, titolo, capienza, tipo));
            }

            // Imposta il valore di cella per la colonna nome
            colRequests.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tabView.setItems(richieste);

            // Aggiungi una colonna per i pulsanti (Accetta e Rifiuta)
            TableColumn<Request, Void> colActions = new TableColumn<>("Azioni");

            colActions.setCellFactory(new Callback<TableColumn<Request, Void>, TableCell<Request, Void>>() {
                @Override
                public TableCell<Request, Void> call(TableColumn<Request, Void> param) {
                    return new TableCell<Request, Void>() {

                        private final Button btnAccept = new Button("Accetta");
                        private final Button btnDecline = new Button("Rifiuta");

                        {
                            // Azione per il pulsante "Accetta"
                            btnAccept.setOnAction(event -> {
                                Request request = getTableView().getItems().get(getIndex());
                                acceptShow(request); // Implementa la logica per accettare lo show
                            });

                            // Azione per il pulsante "Rifiuta"
                            btnDecline.setOnAction(event -> {
                                Request request = getTableView().getItems().get(getIndex());
                                declineShow(request); // Implementa la logica per rifiutare lo show
                            });
                        }

                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                HBox pane = new HBox(btnAccept, btnDecline);
                                pane.setSpacing(10);
                                setGraphic(pane);
                            }
                        }
                    };
                }
            });

            // Aggiungi la colonna delle azioni alla TableView
            tabView.getColumns().add(colActions);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void declineShow(Request request) {

    }

    private void acceptShow(Request request) {

    }


    @FXML
    void handleCerca(ActionEvent event) {

    }

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
