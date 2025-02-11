package com.example.progettomola.model.entity;


import com.example.progettomola.other.Observer;

public class Artist implements Observer {

    private int id;
    private String username;
    private String password;
    private String email;
    private String telefono;
    private String tipo;



    public Artist (int id, String username, String Password, String tipo){
        this.id = id;
        this.username = username;
        this.password = Password;
        this.tipo = tipo;


    }



    @Override
    public void updateRequest(Request request) {
        if(this.tipo.equals(request.getTipo())){
            System.out.println("concordi");
        }
    }

    public void receiveRequest(Request request) {
        System.out.println("Request received: " + request.getNome());
        // Implementa la logica per mostrare i bottoni "accetta" e "rifiuta"
    }



    public String getUsername () {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
