package com.example.progettomola;

public class Show {

    private String nome;
    private String descrizione;
    private int capienza;
    private int partecipanti;


    public Show(String nome, String descrizione, int capienza) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.capienza = capienza;
        this.partecipanti = 0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean aggiungiPartecipante() {
        if (partecipanti > capienza) {
            partecipanti++;
            return true;
        }
        return false;
    }
}
