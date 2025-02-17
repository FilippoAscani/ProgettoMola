package com.example.progettomola.bean;

public class ShowBean {

    private int idShow;
    private String titoloShow;
    private String tipoShow;
    private int capienzaShow;

    public ShowBean() {

    }

    public ShowBean(int idShow, String titoloShow, String tipoShow, int capienzaShow) {
        this.idShow = idShow;
        this.titoloShow = titoloShow;
        this.tipoShow = tipoShow;
        this.capienzaShow = capienzaShow;
    }


    public int getIdShow() {
        return idShow;
    }

    public void setIdShow(int idShow) {
        this.idShow = idShow;
    }

    public String getTitoloShow() {
        return titoloShow;
    }

    public void setTitoloShow(String titoloShow) {
        this.titoloShow = titoloShow;
    }

    public String getTipoShow() {
        return tipoShow;
    }

    public void setTipoShow(String tipoShow) {
        this.tipoShow = tipoShow;
    }

    public int getCapienzaShow() {
        return capienzaShow;
    }

    public void setCapienzaShow(int capienzaShow) {
        this.capienzaShow = capienzaShow;
    }
}
