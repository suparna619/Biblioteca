package com.twu.biblioteca;


public class Book {
    private String name;
    private String author;
    private String yearOfPublish;
    private boolean isBorrowed = false;
    private boolean isReturned = true;

    public Book(String name, String author, String yearOfPublish) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    public String bookDetails() {
        return name +" - "+ author + " - " + yearOfPublish + System.lineSeparator();
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowing() throws Exception{
        if(isBorrowed) throw new Exception();
        this.isBorrowed = true;
        this.isReturned = false;
    }

    public void returnBook() throws Exception{
        if(isReturned) throw new Exception();
        this.isBorrowed = false;
        this.isReturned = true;
    }
}
