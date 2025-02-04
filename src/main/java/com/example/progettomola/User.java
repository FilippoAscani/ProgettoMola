package com.example.progettomola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {

    private String nome;
    private String cognome;
    private String password;
    private String username;

    User(String nome, String cognome, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    User(String nome, String cognome, String password, String username) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return (nome + " " + cognome + " " + password + " ");
    }

    public Artist cercaArtista(String string){

        try {

            String line;
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));

            while ((line = reader.readLine())!= null){
                String[] values = line.split(",");
                if(values[0].equalsIgnoreCase(string)){
                    return new Artist(values[0],values[1]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;


    }

}
