package com.twu.biblioteca;

import java.util.Scanner;

public class AppRunner {
    private Biblioteca biblioteca;

    public AppRunner(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void runBibliotecaApp() {
        Scanner scanner = new Scanner(System.in);
        ListHandeler lh = new ListHandeler(biblioteca);
        StringBuilder sb = createBanner();
        while (true){
            System.out.println(sb);
            String userChoice = scanner.nextLine();
            lh.executeCommand(userChoice);
        }
    }

    private StringBuilder createBanner() {
        StringBuilder sb = new StringBuilder();
        sb.append("Select a proper option");
        sb.append(System.lineSeparator());
        sb.append("----------------------");
        sb.append(System.lineSeparator());
        sb.append("To see the book list : list");
        sb.append(System.lineSeparator());
        sb.append("To check-out a book : check_out");
        sb.append(System.lineSeparator());
        sb.append("To check-in a book : check_in");
        sb.append(System.lineSeparator());
        sb.append("To quit : quit");
        sb.append(System.lineSeparator());
        sb.append("----------------------------------------------");
        return sb;
    }

}
