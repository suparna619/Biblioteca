package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca(args[0],args[1],args[2]);
        System.out.println("*******Welcome to Biblioteca********");
        AppRunner runner = new AppRunner(b);
        runner.runBibliotecaApp();
    }
}