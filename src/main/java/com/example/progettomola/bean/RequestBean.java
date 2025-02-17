package com.example.progettomola.bean;

public class RequestBean {

    private int idB;
    private String nomeB;
    private int capienzaB;
    private String tipoB;

    public RequestBean() {

    }

    public RequestBean(int idB, String nomeB, int capienzaB, String tipoB) {
        this.idB = idB;
        this.nomeB = nomeB;
        this.capienzaB = capienzaB;
        this.tipoB = tipoB;

    }

    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public String getNomeB() {
        return nomeB;
    }

    public void setNomeB(String nomeB) {
        this.nomeB = nomeB;
    }

    public int getCapienzaB() {
        return capienzaB;
    }

    public void setCapienzaB(int capienzaB) {
        this.capienzaB = capienzaB;
    }

    public String getTipoB() {
        return tipoB;
    }

    public void setTipoB(String tipoB) {
        this.tipoB = tipoB;
    }
}
