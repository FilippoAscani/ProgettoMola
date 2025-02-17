package com.example.progettomola.bean;

public class SponsorBean {

    private int idBs;
    private String usernameBs;
    private String passwordBs;

    public SponsorBean() {

    }

    public SponsorBean(int idBs, String usernameBs, String passwordBs) {
        this.idBs = idBs;
        this.usernameBs = usernameBs;
        this.passwordBs = passwordBs;
    }


    public int getIdBs() {
        return idBs;
    }

    public void setIdBs(int idBs) {
        this.idBs = idBs;
    }

    public String getUsernameBs() {
        return usernameBs;
    }

    public void setUsernameBs(String usernameBs) {
        this.usernameBs = usernameBs;
    }

    public String getPasswordBs() {
        return passwordBs;
    }

    public void setPasswordBs(String passwordBs) {
        this.passwordBs = passwordBs;
    }
}
