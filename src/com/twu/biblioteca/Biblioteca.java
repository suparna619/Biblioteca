package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

public class Biblioteca {
    private final LibraryIntialiazer libraryIntialiazer = new LibraryIntialiazer(this);
    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();
    private List<Member> members = new ArrayList<Member>();
    private boolean n;

    Biblioteca(String bookDB, String memberDB, String movieDB){
        books = libraryIntialiazer.registerBooks(bookDB);
        members = libraryIntialiazer.registerMembers(memberDB);
        movies = libraryIntialiazer.registerMovies(movieDB);
    }
    public String showList() {
        String result = "";
        for (Book b : books){
            result += b.details();
        }
        return result;
    }
    public String showMovieList() {
        String result = "";
        for (Movie m : movies){
            result += m.details();
        }
        return result;
    }
    public Member findMember(String memberId){
        for (Member member : members)
            if(member.isThisCustomer(memberId))
                return member;
        return null;
    }
    public Book findBook(String bookName) {
        for (Book book : books)
            if(book.isThisBook(bookName))
                return book;
        return null;
    }
    public Movie findMovie(String movieName) {
        for (Movie movie : movies)
            if(movie.isThisMovie(movieName))
                return movie;
        return null;
    }

    public void allotBook(String bookName, String memberId) {
        findMember(memberId).borrow(findBook(bookName));
    }

    public void allotMovie(String movieName, String memberId) {
        findMember(memberId).borrowMovie(findMovie(movieName));
    }
}
