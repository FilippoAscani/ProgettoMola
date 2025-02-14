package com.example.progettomola.model.entity;

public class Request {

    private int id;
    private String nome;
    private int capienza;
    private String tipo;
    private String status;

    public Request(int id, String nome, int capienza, String tipo){

        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
        this.tipo = tipo;
        this.status = "status";

    }

    @Override
    public String toString() {
        return "Richiesta da " + nome + " Stato: " + status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
