package com.example.progettomola;

public class Review {

    private int id;
    private String content;
    private Show show;
    private User user;

    public Review(int id, User user, String content, Show show) {
        this.id = id;
        this.content = content;
        this.show = show;
        this.user = user;
    }

    public Review(int id, String content) {
        this.id = id;
        this.content = content;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


}
