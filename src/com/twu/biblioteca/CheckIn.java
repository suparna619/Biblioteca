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
                String memberId = getUserId(scanner);
                if (biblioteca.findMember(memberId)!=null && returnBook(scanner, memberId)) return;
                System.out.println("“That is not a valid book to return.”");
            }

            private boolean returnBook(Scanner scanner, String memberId) {
                String bookName = getBookName(scanner);
                Member member = biblioteca.findMember(memberId);
                Book book = biblioteca.findBook(bookName);
                if(book!=null && book.isBorrowed() && member.contains(book)){
                    member.returnBook(biblioteca.findBook(bookName));
                    System.out.println("“Thank you for returning the book.”");
                    return true;
                }
                return false;
            }

            private String getBookName(Scanner scanner) {
                System.out.println("Enter book name :\t");
                return scanner.nextLine();
            }

            private String getUserId(Scanner scanner) {
                System.out.println("Enter Id :\t");
                return scanner.nextLine();
            }
        };
    }
}
