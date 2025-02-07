package com.example.progettomola;

import java.util.List;

public interface RequestDAO {

    void addRequest(Request request); //lo sviluppatore si iscrive(?)
    void updateRequest(Request request); //lo sviluppatore aggiorna le sua info
    void deleteRequest(Request request); // si disinscrive(?)
    List<Request> getRequests(); // forse non serve sapere tutti gli sviluppatori
    Request getRequest(int id); //forse non serve cercare uno sviluppatore

}
