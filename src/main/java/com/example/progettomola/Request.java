package com.example.progettomola;

public class Request {

    private int id;
    private Sponsor sponsor;
    private Artist artist;
    private Show show;
    private String status;

    public Request(int id, Sponsor sponsor, Artist artist, Show show){

        this.id = id;
        this.sponsor = sponsor;
        this.artist = artist;
        this.show = show;
        this.status = "pending";

    }

    @Override
    public String toString() {
        return "Richiesta da " + sponsor + " Stato: " + status;
    }


    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
