package com.example.progettomola;

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
}
