package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

public class Biblioteca {
    private List<Book> books = new ArrayList<Book>();
    private List<Member> members = new ArrayList<Member>();
    private boolean n;

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
        for (Book b : books){
            result += b.bookDetails();
        }
        return result;
    }

    public boolean isValidBookName(String bookName) {
        for (Book book : books)
            if(book.isThisBook(bookName))
                return true;
        return false;
    }
    public Member findMember(String memberId){
        for (Member member : members)
            if(member.isThisCustomer(memberId))
                return member;
        return null;
    }

    public boolean isBookAvailable(String bookName) {
        for (Book book : books)
            if (book.isThisBook(bookName))
                return true;
        return false;
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
