package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca("book.txt");
        System.out.println("Books Available");
        Scanner s = new Scanner(System.in);
        for (;;){
            System.out.println("Enter List to see book list and q for quit");
            String userChoice = s.next();
            if(userChoice.equals("List"))
                System.out.println( b.showList());
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
