package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

/**
 * Created by suparnad on 3/21/2015.
 */
public class Biblioteca {
    List<Book> books = new ArrayList<Book>();
    Biblioteca(){
        welcome();
        createList();
    }

    private void createList() {
        String allBooks = "";
        String[] bookList;
        try {
            allBooks = FileReader.fileReader("book.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookList = allBooks.split("\n");
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
            result+= b.toString() + "\n";
        return result   ;
    }
}
