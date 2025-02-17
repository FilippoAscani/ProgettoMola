package com.example.progettomola.bean;

public class RequestBean {

    private int id;
    private String nome;
    private int capienza;
    private String tipo;

    public RequestBean() {

    }

    public RequestBean(int id, String nome, int capienza, String tipo) {
        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
        this.tipo = tipo;

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
}
