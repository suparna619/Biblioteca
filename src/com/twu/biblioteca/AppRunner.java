package com.twu.biblioteca;

import java.util.Scanner;

/**
* Created by suparnad on 3/23/2015.
*/
public class AppRunner {
    private Biblioteca biblioteca;
    public AppRunner(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void runBibliotecaApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Books Available");
        for (;;){
            System.out.println("Enter List to see book list and q for quit");
            String userChoice = scanner.next();
            if(userChoice.equals("List"))
                System.out.println( biblioteca.showList());
            else if(userChoice.equals("q")){
                System.exit(0);
                break;
            }
            else{
                System.out.println("Select a valid option");
            }
        }
    }

}
