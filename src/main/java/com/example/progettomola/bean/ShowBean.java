package com.example.progettomola.bean;

public class ShowBean {

    private int id;
    private String titolo;
    private String tipo;
    private int capienza;

    public ShowBean() {

    }

    public ShowBean(int id, String titolo, String tipo, int capienza) {
        this.id = id;
        this.titolo = titolo;
        this.tipo = tipo;
        this.capienza = capienza;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
}
