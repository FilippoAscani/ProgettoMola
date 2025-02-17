package com.example.progettomola.model.entity;


import com.example.progettomola.other.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Artist implements Observer {

    private int id;
    private String username;
    private String password;
    private String tipo;



    public Artist (int id, String username, String password, String tipo){
        this.id = id;
        this.username = username;
        this.password = password;
        this.tipo = tipo;


    }

    private static final Logger logger = LoggerFactory.getLogger(Artist.class);



    @Override
    public void updateRequest(Request request) {
        if(this.tipo.equals(request.getTipo())){
            logger.info("concordi");
        }
    }

    public void receiveRequest(Request request) {
        logger.info("{} Request received: {}", this.username, request.getNome());
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
