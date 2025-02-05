package com.example.progettomola;

public class Request {

    private String nome;
    private String sponsor;
    private String tipo;
    private String status;

    public Request(String nome, String sponsor, String tipo){

        this.nome = nome;
        this.sponsor = sponsor;
        this.tipo = tipo;
        this.status = "inviata";
    }

    @Override
    public String toString() {
        return "Richiesta da " + sponsor + " per lo spettacolo " + tipo + " - Stato: " + status;
    }



    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
