package com.twu.biblioteca;


public class Book extends LibraryProduct{
    private final LibraryProduct libraryProduct = new LibraryProduct();
    private String name;
    private String author;
    private String yearOfPublish;

    public Book(String name, String author, String yearOfPublish) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }
    public boolean isThisBook(String bookName) {
        return this.name.equals(bookName);
    }

    public String details() {
        if(libraryProduct.isBorrowed)
            return "";
        return name +" - "+ author + " - " + yearOfPublish + System.lineSeparator();
    }
}
