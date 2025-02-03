package com.example.progettomola;

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

}
