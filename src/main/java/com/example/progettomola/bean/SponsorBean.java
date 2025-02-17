package com.example.progettomola.bean;

public class SponsorBean {

    private int idB;
    private String usernameB;
    private String passwordB;

    public SponsorBean() {

    }

    public SponsorBean(int idB, String usernameB, String passwordB) {
        this.idB = idB;
        this.usernameB = usernameB;
        this.passwordB = passwordB;
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
}
