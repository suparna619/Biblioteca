package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by suparnad on 3/25/2015.
 */
public class CheckOut {
    private Biblioteca biblioteca;

    public CheckOut(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Executable invoke() {
        return new Executable() {
            @Override
            public void execute() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Id :\t");
                String memberId = scanner.nextLine();
                if(biblioteca.findMember(memberId)!=null) {
                    System.out.println("Enter book name :\t");
                    String bookName = scanner.nextLine();
                    if(biblioteca.isValidBookName(bookName) && biblioteca.isBookAvailable(bookName) && !biblioteca.findBook(bookName).isBorrowed()){
                        biblioteca.allotBook(bookName, memberId);
                        System.out.println("“Thank you! Enjoy the book”");
                        return;
                    }
                    System.out.println("“That book is not available”");
                }
            }
        };
    }
}
