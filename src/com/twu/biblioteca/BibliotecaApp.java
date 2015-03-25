package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca("book.txt","members.txt");
        System.out.println("*******Welcome to Biblioteca********");
        AppRunner runner = new AppRunner(b);
        runner.runBibliotecaApp();
    }
}