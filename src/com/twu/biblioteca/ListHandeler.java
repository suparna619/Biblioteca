package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListHandeler {
    private Map<String,Executable> commands = new HashMap<String, Executable>();
    private Biblioteca biblioteca;

    public ListHandeler(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        createCommand();
    }

    private void createCommand() {
        commands.put("list", new Executable() {
            @Override
            public void execute() {
                System.out.println(biblioteca.showList());
            }
        });
        commands.put("quit", new Executable() {
            @Override
            public void execute() {
                System.exit(0);
            }
        });
        commands.put("check_out", new Executable() {
            @Override
            public void execute() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Id :\t");
                String memberId = scanner.next();
                if(biblioteca.findMember(memberId)!=null) {
                    System.out.println("Enter book name :\t");
                    String bookName = "";
                    try {
                        bookName = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(biblioteca.isValidBookName(bookName) && biblioteca.isBookAvailable(bookName) && !biblioteca.findBook(bookName).isBorrowed()){
                        biblioteca.allotBook(bookName, memberId);
                        System.out.println("“Thank you! Enjoy the book”");
                    }
                    System.out.println("“That book is not available”");
                }
            }
        });
        commands.put("check_in", new Executable() {
            @Override
            public void execute() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Id :\t");
                String memberId = scanner.next();
                if(biblioteca.findMember(memberId)!=null) {
                    System.out.println("Enter book name :\t");
                    String bookName = "";
                    try {
                        bookName = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Member member = biblioteca.findMember(memberId);
                    if(biblioteca.isValidBookName(bookName) && !biblioteca.isBookAvailable(bookName) && biblioteca.findBook(bookName).isBorrowed()) {
                        if(member.contains(biblioteca.findBook(bookName))){
                            member.returnBook(biblioteca.findBook(bookName));
                        }
                    }
                }
            }
        });
    }

    public void executeCommand(String userChoice) {
        commands.get(userChoice).execute();
    }
}
