package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private Biblioteca b;
    @Before
    public void setUp() {
        b = new Biblioteca("book.txt", "members.txt", "members.txt");
    }
    @Test
    public void test_showListGivesAllTheBookList() {
        String expected = "The Adventure of Sharlock Homes - Sir Arthur Conan Doyle - 2012" + System.lineSeparator() +
                "Wings of Fire - A.P.J Abdul Kalam - 2011" + System.lineSeparator() +
                "Ramayana - Maharishi Balmiki - 2010" + System.lineSeparator() +
                "Five Point Someone - Chetan Bhagat - 2007" + System.lineSeparator();
        String actual = b.showList();
        assertEquals(expected, actual);
    }

    @Test
    public void IfABookIsAvailableThenAnyMemberCanBorrowIt(){
        b.allotBook("Wings of Fire","1");
        assertTrue(b.findBook("Wings of Fire").isBorrowed());
        assertTrue(b.findMember("1").contains(b.findBook("Wings of Fire")));
    }
    @Test
    public void testIsThisMemberReturnsTrueIfValidIdIsGiven(){
        assertNotNull(b.findMember("1"));
    }

    @Test
    public void testIsThisMemberReturnsFalseIfInvalidIdIsGiven() {
        assertNull(b.findMember("6"));
    }

}