package com.example.progettomola;

import java.util.ArrayList;
import java.util.List;

public class Sponsor implements Subject {

    private int id;
    private String username;
    private String password;
    private List<Observer> artisti;
    private List<Request> requests;


    public Sponsor(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.artisti = new ArrayList<>();
        this.requests = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer o) {
        this.artisti.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.artisti.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Request request : requests) {
            for(Observer artist : artisti) {
                artist.updateRequest(request);
            }

        }
    }


    public void addRequest(int id, String nome, int capienza, String tipo) {
        Request request = new Request(id, nome, capienza, tipo);
        requests.add(request);
        notifyObservers();
    }














    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
