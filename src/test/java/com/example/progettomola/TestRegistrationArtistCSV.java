package com.example.progettomola;

import com.example.progettomola.controllercli.Register;
import com.example.progettomola.model.entity.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;

 class TestRegistrationArtistCSV {

    SecureRandom random = new SecureRandom();

    @Test
    void testRegistrationArtistCSV() throws IOException {
        int id = random.nextInt(10000); // Generazione di un ID casuale per l'artista
        Artist artist = new Artist(id, "picasso", "cubismo", "pittura");


        int initialSize = countLines();

        Register.registraArtistCSV(artist);

        int finalSize = countLines();

        Assertions.assertEquals(initialSize+1, finalSize);

    }

    // Metodo per contare le righe del file CSV (utile per verificare prima e dopo la registrazione)
    private int countLines() throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("artist.csv"))) {
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

}
