package com.example.progettomola.other;

import com.example.progettomola.model.entity.Request;

public interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Request request);
}
