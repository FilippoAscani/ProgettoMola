package com.example.progettomola.bean;

import java.io.Serializable;

public class ArtistBean implements Serializable {

    private int idB;
    private String usernameB;
    private String passwordB;
    private String emailB;
    private String telefonoB;
    private String tipoB;

    public ArtistBean() {

    }

    public ArtistBean(int idB, String usernameB, String passwordB, String emailB, String telefonoB, String tipoB) {
        this.idB = idB;
        this.usernameB = usernameB;
        this.passwordB = passwordB;
        this.emailB = emailB;
        this.telefonoB = telefonoB;
        this.tipoB = tipoB;
    }


    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public String getUsernameB() {
        return usernameB;
    }

    public void setUsernameB(String usernameB) {
        this.usernameB = usernameB;
    }

    public String getPasswordB() {
        return passwordB;
    }

    public void setPasswordB(String passwordB) {
        this.passwordB = passwordB;
    }

    public String getEmailB() {
        return emailB;
    }

    public void setEmailB(String emailB) {
        this.emailB = emailB;
    }

    public String getTelefonoB() {
        return telefonoB;
    }

    public void setTelefonoB(String telefonoB) {
        this.telefonoB = telefonoB;
    }

    public String getTipoB() {
        return tipoB;
    }

    public void setTipoB(String tipoB) {
        this.tipoB = tipoB;
    }
}
