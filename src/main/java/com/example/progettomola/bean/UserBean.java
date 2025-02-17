package com.example.progettomola.bean;

public class UserBean {

    private int idB;
    private String nomeB;
    private String cognomeB;
    private String passwordB;
    private String usernameB;

    public UserBean() {

    }

    public UserBean(int idB, String nomeB, String cognomeB, String passwordB, String usernameB) {
        this.idB = idB;
        this.nomeB = nomeB;
        this.cognomeB = cognomeB;
        this.passwordB = passwordB;
        this.usernameB = usernameB;
    }


    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public String getNomeB() {
        return nomeB;
    }

    public void setNomeB(String nomeB) {
        this.nomeB = nomeB;
    }

    public String getCognomeB() {
        return cognomeB;
    }

    public void setCognomeB(String cognomeB) {
        this.cognomeB = cognomeB;
    }

    public String getPasswordB() {
        return passwordB;
    }

    public void setPasswordB(String passwordB) {
        this.passwordB = passwordB;
    }

    public String getUsernameB() {
        return usernameB;
    }

    public void setUsernameB(String usernameB) {
        this.usernameB = usernameB;
    }
}
