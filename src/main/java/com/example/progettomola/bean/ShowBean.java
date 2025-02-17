package com.example.progettomola.bean;

public class ShowBean {

    private int idB;
    private String titoloB;
    private String tipoB;
    private int capienzaB;

    public ShowBean() {

    }

    public ShowBean(int idB, String titoloB, String tipoB, int capienzaB) {
        this.idB = idB;
        this.titoloB = titoloB;
        this.tipoB = tipoB;
        this.capienzaB = capienzaB;
    }


    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public String getTitoloB() {
        return titoloB;
    }

    public void setTitoloB(String titoloB) {
        this.titoloB = titoloB;
    }

    public String getTipoB() {
        return tipoB;
    }

    public void setTipoB(String tipoB) {
        this.tipoB = tipoB;
    }

    public int getCapienzaB() {
        return capienzaB;
    }

    public void setCapienzaB(int capienzaB) {
        this.capienzaB = capienzaB;
    }
}
