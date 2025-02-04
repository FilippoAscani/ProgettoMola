package com.example.progettomola;

public class Review {

    private String title;
    private String author;
    private String content;

    public Review(String author, String content, String title) {
        this.author = author;
        this.content = content;
        this.title = title;

    }

    public String getAuthor() {
        return author;
    }


    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
