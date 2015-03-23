package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

/**
 * Created by suparnad on 3/21/2015.
 */
public class Biblioteca {
    List<Book> books = new ArrayList<Book>();
    Biblioteca(String fileName){
        welcome();
        createList(fileName);
    }

    private void createList(String fileName) {
        String allBooks = "";
        FileReader fr = new FileReader("book.txt");
        try {
            allBooks = fr.fileReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerBooks(allBooks);
    }

    private void registerBooks(String allBooks) {
        String[] bookList;
        bookList = allBooks.split(System.lineSeparator());
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
