package com.example.progettomola.controllergui;

import com.example.progettomola.DatabaseConnection;
import com.example.progettomola.controllercli.Register;
import com.example.progettomola.model.entity.Request;
import com.example.progettomola.model.entity.Show;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    private final Button btnAccept = new Button("Accetta");
    private final Button btnDecline = new Button("Rifiuta");
    private static final Logger logger = LoggerFactory.getLogger(ArtistRequestController.class);

    ObservableList<Request> richieste = FXCollections.observableArrayList();
    Statement statement = null;
    ResultSet resultSet = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.createStatement();

            String sqlQuery = "SELECT id, nome, capienza, tipo FROM requests";
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int capienza = resultSet.getInt("capienza");
                String tipo = resultSet.getString("tipo");

                richieste.add(new Request(id, nome, capienza, tipo));
            }

            // Imposta il valore di cella per la colonna nome
            colRequests.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tabView.setItems(richieste);

            // Aggiungi una colonna 
            TableColumn<Request, Void> colActions = new TableColumn<>("Azioni");

            colActions.setCellFactory(param -> new TableCell<Request, Void>() {


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

            });

            // Aggiungi la colonna delle azioni alla TableView
            tabView.getColumns().add(colActions);

            initializeButton();


        } catch (Exception e) {
            throw new IllegalStateException("Impossibile caricare le richieste", e);
        }
    }

    private void declineShow(Request request) {

        request.setStatus("accettata");

        int index = richieste.indexOf(request);
        if (index != -1) {
            richieste.remove(index);  // Rimuovi la richiesta alla posizione trovata


        }


    }

    private void acceptShow(Request request) {
        Show show = new Show(request.getId(), request.getNome(), request.getCapienza(), request.getTipo());
        Register.registraShowDB(show);
        Register.registraShowCSV(show);
        request.setStatus("accettata");

        int index = richieste.indexOf(request);
        if (index != -1) {
            richieste.remove(index);

        }

    }


    @FXML
    void handleCerca(ActionEvent event) {
        tabView.setItems(FXCollections.observableArrayList());
    }

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata artist profile", e);
        }

    }

    private void initializeButton(){

        btnAccept.setOnAction(event -> {
            Request req = tabView.getSelectionModel().getSelectedItem();
            if (req != null) {
                acceptShow(req);
            }
            else{
                logger.info("nessuna richiesta accettata");
            }
        });

        btnDecline.setOnAction(event -> {
            Request req = tabView.getSelectionModel().getSelectedItem();
            if(req != null){
                declineShow(req);
            }
            else{
                logger.info("nessuna richiesta rifiutata");
            }

        });


    }






}
