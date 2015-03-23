package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

public class FileWriterTest extends TestCase {

    @Test
    public void testFileWriterAppendsStringInsideAnExistingFile(){
        FileWrite fw = new FileWrite();
        FileReader fr = new FileReader("hello.txt");
        String text = "World";
        String actual = null;
        String expected = "Hello" + System.lineSeparator() + text + System.lineSeparator();
        try {
            fw.fileWrite(text, "hello.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            actual = fr.fileReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }
}