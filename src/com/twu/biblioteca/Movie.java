package com.twu.biblioteca;

/**
 * Created by suparnad on 3/25/2015.
 */
public class Movie extends Book {
    private String movieName;
    private String directorName;
    private String yearOfRelease;
    private String ratting;
    private boolean isBorrowed = false;
    private boolean isReturned = true;
    
    Movie(String movieName, String directorName, String yearOfRelease, String ratting) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.yearOfRelease = yearOfRelease;
        this.ratting = ratting;
    }

    public Movie(String name, String author, String yearOfPublish) {
        super(name, author, yearOfPublish);
    }

    @Override
    public String details() {
        if(isBorrowed)
            return "";
        return movieName +" - "+ directorName + " - " + yearOfRelease + " - " + ratting + System.lineSeparator();
    }
}
