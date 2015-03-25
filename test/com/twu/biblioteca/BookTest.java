package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class BookTest extends TestCase {
    @Test
    public void testIsBorrowedReturnsFalseIfAnyBookIsNotBorrowed(){
        Book refactoring = new Book("Refactoring", "Martin Fowler", "2006");
        assertFalse(refactoring.isBorrowed());
    }

    @Test
    public void testBorrowingThrowsExceptionIfTryingToBorrowAAlreadyBorrowedBook(){
        Book refactoring = new Book("Refactoring", "Martin Fowler", "2006");
        Boolean ifBorrowed = false;
        try {
            refactoring.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            refactoring.borrowing();
        } catch (Exception e) {
            ifBorrowed = true;
        }
        assertTrue(ifBorrowed);
    }

    @Test
    public void testIsBorrowedBecomefalseAfterReturningABook(){
        Book refactoring = new Book("Refactoring", "Martin Fowler", "2006");
        assertFalse(refactoring.isBorrowed());
        boolean falseMove = false;
        try {
            refactoring.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(refactoring.isBorrowed());
        try {
            refactoring.returnProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(refactoring.isBorrowed());
        try {
            refactoring.returnProduct();
        } catch (Exception e) {
            falseMove = true;
        }
        assertTrue(falseMove);
    }
}