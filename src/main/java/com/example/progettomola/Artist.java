package com.example.progettomola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Artist {

    private String nome;
    private String password;
    private String email;
    private String telefono;
    private String tipo;



    public Artist (String nome, String password, String email, String telefono, String tipo) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;

    }

    public Artist (String nome, String Password){
        this.nome = nome;
        this.password = Password;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Artist cercaArtista(String nome){

        try {

            String line;
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));

            while ((line = reader.readLine())!= null){
                String[] values = line.split(",");
                if(values[0].equalsIgnoreCase(nome)){
                    return new Artist(values[0],values[1]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;


    }

}
