package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class BibliotecaTest extends TestCase {
    @Test
    public void test_showListGivesAllTheBookList() {
        Biblioteca b = new Biblioteca("book.txt", "members.txt");
        String expected = "The Adventure of Sharlock Homes - Sir Arthur Conan Doyle - 2012" + System.lineSeparator() +
                "Wings of Fire - A.P.J Abdul Kalam - 2011" + System.lineSeparator() +
                "Ramayana - Maharishi Balmiki - 2010" + System.lineSeparator() +
                "Five Point Someone - Chetan Bhagat - 2007" + System.lineSeparator();
        String actual = b.showList();
        assertEquals(expected, actual);
    }

}