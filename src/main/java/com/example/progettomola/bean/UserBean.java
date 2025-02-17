package com.example.progettomola.bean;

public class UserBean {

    private int idBu;
    private String nomeBu;
    private String cognomeBu;
    private String passwordBu;
    private String usernameBu;

    public UserBean() {

    }

    public UserBean(int idBu, String nomeBu, String cognomeBu, String passwordBu, String usernameBu) {
        this.idBu = idBu;
        this.nomeBu = nomeBu;
        this.cognomeBu = cognomeBu;
        this.passwordBu = passwordBu;
        this.usernameBu = usernameBu;
    }


    public int getIdBu() {
        return idBu;
    }

    public void setIdBu(int idBu) {
        this.idBu = idBu;
    }

    public String getNomeBu() {
        return nomeBu;
    }

    public void setNomeBu(String nomeBu) {
        this.nomeBu = nomeBu;
    }

    public String getPasswordBu() {
        return passwordBu;
    }

    public void setPasswordBu(String passwordBu) {
        this.passwordBu = passwordBu;
    }

    public String getCognomeBu() {
        return cognomeBu;
    }

    public void setCognomeBu(String cognomeBu) {
        this.cognomeBu = cognomeBu;
    }

    public String getUsernameBu() {
        return usernameBu;
    }

    public void setUsernameBu(String usernameBu) {
        this.usernameBu = usernameBu;
    }
}
