package com.twu.biblioteca;

import java.util.Scanner;


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
                String memberId = getUserId(scanner);
                if (ifValidMemberAndBookBorrower(scanner, memberId)) return;
                System.out.println("“That book is not available”");
            }

            private boolean ifValidMemberAndBookBorrower(Scanner scanner, String memberId) {
                return biblioteca.findMember(memberId)!=null && borrowBook(scanner, memberId);
            }

            private boolean borrowBook(Scanner scanner, String memberId) {
                String bookName = getBookName(scanner);
                Book book = biblioteca.findBook(bookName);
                if(ifValidBookAndIsBorrowed(bookName, book)){
                    biblioteca.allotBook(bookName, memberId);
                    System.out.println("“Thank you! Enjoy the book”");
                    return true;
                }
                return false;
            }

            private boolean ifValidBookAndIsBorrowed(String bookName, Book book) {
                return book!=null && !biblioteca.findBook(bookName).isBorrowed();
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
