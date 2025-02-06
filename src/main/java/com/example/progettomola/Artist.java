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
    private List<Show> shows;
    private List<Request> sosRequests;


    public Artist (int id, String username, String password, String email, String telefono, String tipo) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.id = id;
        shows = new ArrayList<>();
        sosRequests = new ArrayList<>();


    }

    public Artist (int id, String username, String Password){
        this.id = id;
        this.username = username;
        this.password = Password;

    }


    //metodo accetta o rifiuta richiesta
    public void acceptRequest (Request request) {
        if(sosRequests.contains(request)){
            shows.add(request.getShow());
            sosRequests.remove(request);
            System.out.println(this.username + " accepted");
        }
    }

    public void declineRequest(Request request) {
        if(sosRequests.contains(request)){
            sosRequests.remove(request);
            System.out.println(this.username + " declined");
        }
    }


    @Override
    public void updateRequest(Request request) {
        System.out.println("nuova richiesta per " + this.username + ": " + request);
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
