package com.twu.biblioteca;

import java.util.Scanner;


public class CheckInBook {
    private final Biblioteca biblioteca;

    public CheckInBook(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Executable invoke() {
        return new Executable() {
            @Override
            public void execute() {
                Scanner scanner = new Scanner(System.in);
                String memberId = getUserId(scanner);
                if (isValidMemberAndhasBook(scanner, memberId)) return;
                System.out.println("“That is not a valid book to return.”");
            }

            private boolean isValidMemberAndhasBook(Scanner scanner, String memberId) {
                return biblioteca.findMember(memberId)!=null && returnBook(scanner, memberId);
            }

            private boolean returnBook(Scanner scanner, String memberId) {
                String bookName = getBookName(scanner);
                Member member = biblioteca.findMember(memberId);
                Book book = biblioteca.findBook(bookName);
                if(isValidBookAndIsBorrowedBookAndHasBook(member, book)){
                    member.returnBook(biblioteca.findBook(bookName));
                    System.out.println("“Thank you for returning the book.”");
                    return true;
                }
                return false;
            }

            private boolean isValidBookAndIsBorrowedBookAndHasBook(Member member, Book book) {
                return book!=null && book.isBorrowed() && member.contains(book);
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
