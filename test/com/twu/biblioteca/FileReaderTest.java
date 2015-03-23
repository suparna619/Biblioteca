package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;



public class FileReaderTest extends TestCase {
    private FileReader fr  = null;
    @Test
    public void test_File_readerReadsAndGivesTheContentOfGivenFile() {
        fr = new FileReader("foo.txt");
        String expected = "foobar";
        String actual = null;
        try {
            actual = fr.fileReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(expected.equals(actual));
    }

    @Test
    public void test_File_readerReadsAndGivesFileNotFoundException() {
        boolean isFileNotFound = false;
        fr = new FileReader("fool.txt");
        try {
            fr.fileReader();
        } catch (Exception e) {
            isFileNotFound = true;
        }
        assertTrue(isFileNotFound);
    }
}