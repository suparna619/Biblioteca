package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class MovieTest extends TestCase {

    @Test
    public void testIsBorrowedReturnsFalseIfAnyMovieIsNotBorrowed(){
        Movie lagan = new Movie("Lagan","Asutosh Goriakar","2003","8.0");
        assertFalse(lagan.isBorrowed());
    }

    @Test
    public void testBorrowingThrowsExceptionIfTryingToBorrowAAlreadyBorrowedMovie(){
        Movie lagan = new Movie("Lagan","Asutosh Goriakar","2003","8.0");
        Boolean ifBorrowed = false;
        try {
            lagan.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lagan.borrowing();
        } catch (Exception e) {
            ifBorrowed = true;
        }
        assertTrue(ifBorrowed);
    }

    @Test
    public void testIsBorrowedBecomefalseAfterReturningAMovie(){
        Movie lagan = new Movie("Lagan","Asutosh Goriakar","2003","8.0");
        assertFalse(lagan.isBorrowed());
        boolean falseMove = false;
        try {
            lagan.borrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(lagan.isBorrowed());
        try {
            lagan.returnBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(lagan.isBorrowed());
        try {
            lagan.returnBook();
        } catch (Exception e) {
            falseMove = true;
        }
        assertTrue(falseMove);
    }

}