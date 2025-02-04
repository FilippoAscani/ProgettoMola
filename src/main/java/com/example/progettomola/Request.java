package com.example.progettomola;

public class Request {

    private String artista;
    private String sponsor;
    private String show;
    private String status;

    public Request(String artista, String sponsor, String show, String status){
        this.artista = artista;
        this.sponsor = sponsor;
        this.show = show;
        this.status = status;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Richiesta da " + sponsor + " per l'artista " + artista + " per lo spettacolo " + show + " - Stato: " + status;
    }

}
