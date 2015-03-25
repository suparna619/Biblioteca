package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by suparnad on 3/25/2015.
 */
public class CheckIn {
    private final Biblioteca biblioteca;

    public CheckIn(Biblioteca biblioteca) {
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
                    Member member = biblioteca.findMember(memberId);
                    Book book = biblioteca.findBook(bookName);
                    if(biblioteca.isValidBookName(bookName) && book.isBorrowed()) {
                        if(member.contains(book)){
                            member.returnBook(biblioteca.findBook(bookName));
                        }
                    }
                }
            }
        };
    }
}
