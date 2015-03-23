package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

public class Biblioteca {
    private List<Book> books = new ArrayList<Book>();
    private List<Member> members = new ArrayList<Member>();

    Biblioteca(String bookDB, String memberDB){
        welcome();
        registerBooks(bookDB);
        registerMembers(memberDB);
    }

    private String readDB(String DB) {
        String content = "";
        FileReader fr = new FileReader(DB);
        try {
            content = fr.fileReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    private void registerMembers(String memberDB) {
        String allMembers = readDB(memberDB);
        String[] memberList = allMembers.split(System.lineSeparator());
        for (String member : memberList){
            String[] bookDetails = member.split(" - ");
            members.add(new Member(bookDetails[0],bookDetails[1]));
        }
    }

    private void registerBooks(String bookDB) {
        String allBooks = readDB(bookDB);
        String[] bookList = allBooks.split(System.lineSeparator());
        for (String book : bookList){
            String[] bookDetails = book.split(" - ");
            books.add(new Book(bookDetails[0],bookDetails[1],bookDetails[2]));
        }
    }

    private void welcome() {
        System.out.println("Welcome to Biblioteca");
    }

    public String showList() {
        String result = "";
        for (Book b : books)
            result += b.bookDetails();
        return result;
    }
}
