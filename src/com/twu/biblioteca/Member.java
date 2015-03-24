package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suparnad on 3/23/2015.
 */
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
}
