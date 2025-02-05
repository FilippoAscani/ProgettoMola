package com.example.progettomola;

import java.util.ArrayList;
import java.util.List;

public class Sponsor implements Subject {

    private int id;
    private String username;
    private String password;
    private List<Observer> observers;


    public Sponsor(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.observers = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Request request) {
        for(Observer o : observers) {
            o.updateRequest(request);
        }
    }


    public void createRequest(Show show, String tipo) {
        Request request = new Request(show.getNome(), this.username, tipo);
        notifyObservers(request);
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



    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }


}
