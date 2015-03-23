package com.twu.biblioteca;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by suparnad on 3/21/2015.
 */
public class FileReader {
    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public String fileReader() throws Exception {
        return new String(readAllBytes(get(fileName)));
    }
}
