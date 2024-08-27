package org.northcoders.model;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String description;
    private String isbn;
    private String image;
    private Date published;
    private String publisher;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getImage() {
        return image;
    }

    public Date getPublished() {
        return published;
    }

    public String getPublisher() {
        return publisher;
    }
}
