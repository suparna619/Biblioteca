package com.twu.biblioteca;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by suparnad on 3/21/2015.
 */
public class FileReader {
    public static String fileReader(String fileName) throws Exception {
        try{
            readAllBytes(get(fileName));
        }
        catch(Exception err){}
        return new String(readAllBytes(get(fileName)));
    }
}
