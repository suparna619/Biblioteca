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
            String[] bookDetails = member.split(" - ");
            members.add(new Member(bookDetails[0], bookDetails[1]));
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
}