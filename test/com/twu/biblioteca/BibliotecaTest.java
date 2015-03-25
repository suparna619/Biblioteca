package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private Biblioteca b;
    @Before
    public void setUp() {
        b = new Biblioteca("book.txt", "members.txt", "movies.txt");
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
    public void test_showMovieListGivesAllTheMovieList() {
        String expected = "Lagan - Ashutosh Gowariker - 2001 - 8.0" + System.lineSeparator() +
                "3 Idiots - Rajkumar Hirani - 2009 - 8.5" + System.lineSeparator() +
                "Water - Deepa Mehta - 2005 - 7.2" + System.lineSeparator() +
                "Gran Torino - Clint Eastwood - 2008 - 7.7" + System.lineSeparator() +
                "Terminator 2: Judgment Day - James Cameron - 1991 - 8.0" + System.lineSeparator();
        String actual = b.showMovieList();
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