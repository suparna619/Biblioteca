package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Member {
    private String name;
    private String id;
    private List<Book> books = new ArrayList<Book>();
    Member(String name, String id){
        this.id = id;
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
            book.returnBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
