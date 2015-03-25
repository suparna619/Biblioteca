package com.twu.biblioteca;

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
        commands.put("book_list", new Executable() {
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
        commands.put("check_out_book", new CheckOutBook(biblioteca).invoke());
        commands.put("check_in_book", new CheckInBook(biblioteca).invoke());
        commands.put("movie_list", new Executable() {
            @Override
            public void execute() {
                System.out.println(biblioteca.showMovieList());
            }
        });
        commands.put("check_out_movie",new CheckOutMovie(biblioteca).invoke());
        commands.put("check_in_movie", new CheckInMovie(biblioteca).invoke());
        commands.put("check_details", new Executable() {
            @Override
            public void execute() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter password : ");
                String password = scanner.nextLine();
                Member member = biblioteca.findMember(password);
                if(member!=null){
                    System.out.println(member.getDetails());
                    return;
                }
                System.out.println("Enter proper password");
            }
        });

    }

    public void executeCommand(String userChoice) {
        try {
            commands.get(userChoice).execute();
        }catch (Exception e){
            System.out.println("Opps!!!!Wrong Option entered - Please choose a Valid Option");
        }
    }
}
