package com.example.progettomola;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NoClassUno {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");

    }
}