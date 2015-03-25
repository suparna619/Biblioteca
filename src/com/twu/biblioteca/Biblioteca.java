package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

public class Biblioteca {
    private final LibraryIntialiazer libraryIntialiazer = new LibraryIntialiazer(this);
    private List<Book> books = new ArrayList<Book>();
    private List<Member> members = new ArrayList<Member>();
    private boolean n;

    Biblioteca(String bookDB, String memberDB){
        books = libraryIntialiazer.registerBooks(bookDB);
        members = libraryIntialiazer.registerMembers(memberDB);
    }

    public String showList() {
        String result = "";
        for (Book b : books){
            result += b.bookDetails();
        }
        return result;
    }

    public Member findMember(String memberId){
        for (Member member : members)
            if(member.isThisCustomer(memberId))
                return member;
        return null;
    }

    public Book findBook(String bookName) {
        for (Book book : books)
            if(book.isThisBook(bookName))
                return book;
        return null;
    }

    public void allotBook(String bookName, String memberId) {
        findMember(memberId).borrow(findBook(bookName));
    }
}
