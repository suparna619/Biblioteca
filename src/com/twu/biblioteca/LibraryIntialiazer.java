package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LibraryIntialiazer {
    private final Biblioteca biblioteca;

    public LibraryIntialiazer(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public String readDB(String DB) {
        String content = "";
        FileReader fr = new FileReader(DB);
        try {
            content = fr.fileReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public List<Member> registerMembers(String memberDB) {
        List<Member> members = new ArrayList<Member>();
        String allMembers = readDB(memberDB);
        String[] memberList = allMembers.split(System.lineSeparator());
        for (String member : memberList) {
            String[] memberDetails = member.split(" - ");
            members.add(new Member(memberDetails[0], memberDetails[1], memberDetails[2], memberDetails[3],memberDetails[4]));
        }
        return members;
    }
    public List<Book> registerBooks(String bookDB) {
        String allBooks = readDB(bookDB);
        List<Book> books = new ArrayList<Book>();
        String[] bookList = allBooks.split(System.lineSeparator());
        for (String book : bookList) {
            String[] bookDetails = book.split(" - ");
            books.add(new Book(bookDetails[0], bookDetails[1], bookDetails[2]));
        }
        return books;
    }

    public List<Movie> registerMovies(String movieDB) {
        String allMovies = readDB(movieDB);
        List<Movie> movies = new ArrayList<Movie>();
        String[] movieList = allMovies.split(System.lineSeparator());
        for (String movie : movieList) {
            String[] movieDetail = movie.split(" - ");
            movies.add(new Movie(movieDetail[0], movieDetail[1], movieDetail[2],movieDetail[3]));
        }
        return movies;
    }

}