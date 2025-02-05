package com.example.progettomola;


import java.util.ArrayList;
import java.util.List;

public class Artist implements Observer{

    private int id;
    private String username;
    private String password;
    private String email;
    private String telefono;
    private String tipo;
    private List<Request> recRequests;


    public Artist (int id, String username, String password, String email, String telefono, String tipo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.id = id;


    }

    public Artist (int id, String username, String Password){
        this.id = id;
        this.username = username;
        this.password = Password;

    }


    //metodo accetta o rifiuta richiesta
    public void acceptRequest () {

    }

    public void declineRequest() {

    }


    @Override
    public void updateRequest(Request request) {
        if(request.getTipo().equalsIgnoreCase(this.tipo)){
            recRequests.add(request);
            System.out.println(this.username + "hai ricevuto una richiesta da " + request.getSponsor());
        }
    }














    public String getUsername () {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
