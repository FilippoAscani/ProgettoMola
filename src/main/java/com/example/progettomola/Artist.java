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
    private List<Request> recRequests;



    public Artist (int id, String username, String password, String email, String telefono, String tipo) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.id = id;
        shows = new ArrayList<>();
        recRequests = new ArrayList<>();



    }

    public Artist (int id, String username, String Password, String tipo){
        this.id = id;
        this.username = username;
        this.password = Password;
        this.tipo = tipo;
        shows = new ArrayList<>();
        recRequests = new ArrayList<>();

    }


    //metodo accetta e crea show aggiunge show all'elenco?
    public void acceptRequest (Request request) {
        request.setStatus("accepted");
        Show show = new Show(request.getId(),request.getNome(), request.getCapienza(), request.getTipo());
        shows.add(show);
        saveShow(show);
    }

    public void declineRequest(Request request) {
        request.setStatus("declined");
    }




    @Override
    public void updateRequest(Request request) {
        if(this.tipo.equals(request.getTipo())){
            recRequests.add(request);
        }
    }



    public void saveShow(Show show) {
        shows.add(show);
    }



    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }


    public void setRequests(ArrayList<Request> requests) {
        this.recRequests = requests;
    }

    public List<Request> getRequests() {
        return recRequests;
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
