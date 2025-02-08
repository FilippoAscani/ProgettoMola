package com.example.progettomola.Other;

import com.example.progettomola.Model.Entity.Request;

public interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Request request);
}
