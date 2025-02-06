package com.example.progettomola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class User {

    private int id;
    private String nome;
    private String cognome;
    private String password;
    private String username;
    private List<Review> reviews;

    User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    User(String nome, String cognome, String password, String username, int id) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.username = username;

    }


    public Artist cercaArtista(String string){

        try {

            String line;
            BufferedReader reader = new BufferedReader(new FileReader("artist.csv"));

            while ((line = reader.readLine())!= null){
                String[] values = line.split(",");
                if(values[1].equalsIgnoreCase(string)){
                    return new Artist(Integer.parseInt(values[0]),values[1],values[2]);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;


    }

    private int generateId(){
        Random random = new Random();
        return random.nextInt();
    }

    public void writeReview(String content, Show show){
        Review review = new Review(generateId(), this, content, show);
    }


    public List<Review> getReviews(){
        return this.reviews;
    }




    public void acceptRequest(Request request){
        System.out.println("richiesta accetata");
        //rendi disponibile show a tutti gli utenti
    }

    public void declineRequest(Request request){
        System.out.println("richiesta rifiutata");
        //non fare nulla
    }





















    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return (nome + " " + cognome + " " + password + " ");
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //a prestooo

}
