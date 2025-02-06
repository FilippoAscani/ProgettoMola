package com.example.progettomola;

public class Show {

    private int id;
    private String titolo;
    private String descrizione;
    private int capienza;
    private int partecipanti;


    public Show(int id, String titolo, String descrizione, int capienza) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.capienza = capienza;
        this.partecipanti = 0;
    }



    public boolean aggiungiPartecipante() {
        if (partecipanti > capienza) {
            partecipanti++;
            return true;
        }
        return false;
    }







    public String getTitolo() {
        return titolo;
    }

    public void setNome(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public int getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(int partecipanti) {
        this.partecipanti = partecipanti;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
