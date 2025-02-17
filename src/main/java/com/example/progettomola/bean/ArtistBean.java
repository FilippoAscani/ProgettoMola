package com.example.progettomola.bean;

import java.io.Serializable;

public class ArtistBean implements Serializable {

    private int idBa;
    private String usernameBa;
    private String passwordBa;
    private String tipoBa;

    public ArtistBean() {

    }

    public ArtistBean(int idBa, String usernameBa, String passwordBa, String tipoBa) {
        this.idBa = idBa;
        this.usernameBa = usernameBa;
        this.passwordBa = passwordBa;
        this.tipoBa = tipoBa;
    }


    public int getIdBa() {
        return idBa;
    }

    public void setIdBa(int idBa) {
        this.idBa = idBa;
    }

    public String getUsernameBa() {
        return usernameBa;
    }

    public void setUsernameBa(String usernameBa) {
        this.usernameBa = usernameBa;
    }

    public String getPasswordBa() {
        return passwordBa;
    }

    public void setPasswordBa(String passwordBa) {
        this.passwordBa = passwordBa;
    }

    public String getTipoBa() {
        return tipoBa;
    }

    public void setTipoBa(String tipoBa) {
        this.tipoBa = tipoBa;
    }
}
