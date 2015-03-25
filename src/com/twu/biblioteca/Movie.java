package com.twu.biblioteca;

/**
 * Created by suparnad on 3/25/2015.
 */
public class Movie extends LibraryProduct {
    private String movieName;
    private String directorName;
    private String yearOfRelease;
    private String ratting;

    Movie(String movieName, String directorName, String yearOfRelease, String ratting) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
        this.ratting = ratting;
    }

    public String details() {
        if(isBorrowed)
            return "";
        return movieName +" - "+ directorName + " - " + yearOfRelease + " - " + ratting + System.lineSeparator();
    }

    public boolean isThisMovie(String movieName) {
        return this.movieName.equals(movieName);
    }
}
