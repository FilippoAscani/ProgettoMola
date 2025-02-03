package com.example.progettomola;

public class Show {

    private String nomeShow;
    private String descrizioneShow;
    private int capienzaShow;
    private String tipoShow;

    public Show(String nomeShow, String descrizioneShow, int capienzaShow, String tipoShow) {
        this.nomeShow = nomeShow;
        this.descrizioneShow = descrizioneShow;
        this.capienzaShow = capienzaShow;
        this.tipoShow = tipoShow;
    }


    public String getNomeShow() {
        return nomeShow;
    }

    public void setNomeShow(String nomeShow) {
        this.nomeShow = nomeShow;
    }

    public String getDescrizioneShow() {
        return descrizioneShow;
    }

    public void setDescrizioneShow(String descrizioneShow) {
        this.descrizioneShow = descrizioneShow;
    }

    public int getCapienzaShow() {
        return capienzaShow;
    }

    public void setCapienzaShow(int capienzaShow) {
        this.capienzaShow = capienzaShow;
    }

    public String getTipoShow() {
        return tipoShow;
    }

    public void setTipoShow(String tipoShow) {
        this.tipoShow = tipoShow;
    }
}
