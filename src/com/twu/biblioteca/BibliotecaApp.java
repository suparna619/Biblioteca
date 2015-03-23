package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca("book.txt");
        System.out.println("Books Available");
        Scanner s = new Scanner(System.in);
        AppRunner runner = new AppRunner(b, s);
        runner.runBibliotecaApp();
    }

}
