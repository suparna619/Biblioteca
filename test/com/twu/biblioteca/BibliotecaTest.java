package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class BibliotecaTest extends TestCase {
    @Test
    public void test_showListGivesAllTheBookList() {
        Biblioteca b = new Biblioteca();
        String expected = "The Adventure of Sharlock Homes - Sir Arthur Conan Doyle - 2012\r\n" +
                "Wings of Fire - A.P.J Abdul Kalam - 2011\r\n" +
                "Ramayana - Maharishi Balmiki - 2010\r\n" +
                "Five Point Someone - Chetan Bhagat - 2007\r\n";
        String actual = b.showList();
        assertEquals(expected, actual);
    }

}