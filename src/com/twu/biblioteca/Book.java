package com.twu.biblioteca;

/**
 * Created by suparnad on 3/21/2015.
 */
public class Book {
    private String name;
    private String author;
    private String yearOfPublish;

    public Book(String name, String author, String yearOfPublish) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    @Override
    public String toString() {
        return name +" - "+ author +" - "+ yearOfPublish;
    }
}
