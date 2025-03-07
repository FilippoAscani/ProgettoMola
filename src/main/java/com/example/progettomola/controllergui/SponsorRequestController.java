package com.example.progettomola.controllergui;

import com.example.progettomola.controllercli.Register;
import com.example.progettomola.model.entity.Artist;
import com.example.progettomola.model.entity.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SponsorRequestController {

    @FXML
    private Button btnCrea;

    @FXML
    private Button btnIndietro;

    @FXML
    private TextField txtCapienza;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtTitolo;


    private static final Logger logger = LoggerFactory.getLogger(SponsorRequestController.class);

    @FXML
    void handleCrea(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());
        String tipo = txtTipo.getText();
        String titolo = txtTitolo.getText();
        int cap = Integer.parseInt(txtCapienza.getText());
        Request request = new Request(id, titolo, cap, tipo);

        Register.registraRequestDB(request);
        Register.registraRequestCSV(request);
        //inviare la richiesta agli artisti che hanno il tipo della richiesta uguale al loro

        try {
            for (Artist artist : loadArtistsFromCSV()) {
                if (artist.getTipo().equals(tipo)) {
                    sendRequestToArtist(request, artist);



                }
            }
        } catch (IOException e) {
            logger.info("impossibile cercare sponsor csv");
        }

    }


    private void sendRequestToArtist(Request request, Artist artist) {
        artist.receiveRequest(request);
    }

    private List<Artist> loadArtistsFromCSV() throws IOException {
        List<Artist> artists = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("artist.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                artists.add(new Artist(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]));
            }
        }
        return artists;
    }
    
    

    @FXML
    void handleIndietro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-profile-view.fxml")));
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor profile", e);
        }
    }

}

