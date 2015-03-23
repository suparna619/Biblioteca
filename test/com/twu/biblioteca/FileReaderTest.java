package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

public class FileReaderTest extends TestCase {
    @Test
    public void test_File_readerReadsAndGivesTheContentOfGivenFile() {
        String expected = "foobar";
        String actual = null;
        try {
            actual = FileReader.fileReader("foo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(expected.equals(actual));
    }
}