package com.example.progettomola.model.entity;

import com.example.progettomola.other.Observer;
import com.example.progettomola.other.Subject;

import java.util.ArrayList;
import java.util.List;

public class Sponsor implements Subject {

    private int id;
    private String username;
    private String password;
    private List<Observer> observers;
    private List<Request> sendRequests;


    public Sponsor(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.observers = new ArrayList<>();
        this.sendRequests = new ArrayList<>();
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

    public void createRequest(Request request) {
        sendRequests.add(request);
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

    public void setRequests (List<Request> requests) {
        this.sendRequests = requests;
    }

    public List<Request> getRequests() {
        return sendRequests;
    }

    public void setArtisti (List<Observer> artisti) {
        this.observers = artisti;
    }

    public List<Observer> getArtisti() {
        return observers;
    }


}
