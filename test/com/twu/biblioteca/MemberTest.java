package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class MemberTest extends TestCase {
    @Test
    public void testBorrowTakesABookAndAddsItIntoMembersBookList(){
        Member m = new Member("Prasenjit","2");
        Book book = new Book("Ramayana","Tulsidas","0210");
        assertFalse(book.isBorrowed());
        assertFalse(m.contains(book));
        m.borrow(book);
        assertTrue(m.contains(book));
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testReturnRemovesABookFromMemberBookListAndMakeItAvailableForOtherCustomer(){
        Member m = new Member("Prasenjit","2");
        Book book = new Book("Ramayana","Tulsidas","0210");
        assertFalse(book.isBorrowed());
        assertFalse(m.contains(book));
        m.borrow(book);
        assertTrue(m.contains(book));
        assertTrue(book.isBorrowed());
        m.returnBook(book);
        assertFalse(m.contains(book));
        assertFalse(book.isBorrowed());
    }

}