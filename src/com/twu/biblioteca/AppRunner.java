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
        sb.append("To see the book list : book_list");
        sb.append(System.lineSeparator());
        sb.append("To see the movie list : movie_list");
        sb.append(System.lineSeparator());
        sb.append("To check-out a book : check_out_book");
        sb.append(System.lineSeparator());
        sb.append("To check-in a book : check_in_book");
        sb.append(System.lineSeparator());
        sb.append("To check-out a movie : check_out_movie");
        sb.append(System.lineSeparator());
        sb.append("To check-in a movie : check_in_movie");
        sb.append(System.lineSeparator());
        sb.append("To quit : quit");
        sb.append(System.lineSeparator());
        sb.append("----------------------------------------------");
        return sb;
    }

}
