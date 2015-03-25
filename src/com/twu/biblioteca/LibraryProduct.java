package com.twu.biblioteca;

public class LibraryProduct {
    public boolean isBorrowed = false;
    public boolean isReturned = true;

    public LibraryProduct() {
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowing() throws Exception {
        if (isBorrowed) throw new Exception();
        this.isBorrowed = true;
        this.isReturned = false;
    }

    public void returnProduct() throws Exception {
        if (isReturned) throw new Exception();
        this.isBorrowed = false;
        this.isReturned = true;
    }
}