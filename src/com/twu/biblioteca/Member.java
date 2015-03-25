package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Member {
    private String name;
    private String email;
    private String phNo;
    private String libraryId;
    private String id;
    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();

    Member(String name, String email, String phNo, String libraryId, String password){
        this.email = email;
        this.phNo = phNo;
        this.libraryId = libraryId;
        this.id = password;
        this.name = name;
    }
    public boolean isThisCustomer(String id) {
        return this.id.equals(id);
    }

    public void borrow (Book book){
        books.add(book);
        try {
            book.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean contains(Book book) {
        return books.contains(book);
    }

    public void returnBook(Book book) {
        books.remove(book);
        try {
            book.returnProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrowMovie(Movie movie) {
        movies.add(movie);
        try {
            movie.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasMovie(Movie movie) {
        return movies.contains(movie);
    }

    public void returnMovie(Movie movie) {
        movies.remove(movie);
        try {
            movie.returnProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDetails() {
        return name + " - " + email + " - " + phNo;
    }
}
