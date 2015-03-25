package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

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
        commands.put("check_out", new CheckOut(biblioteca).invoke());
        commands.put("check_in", new CheckIn(biblioteca).invoke());
        commands.put("movie_list", new Executable() {
            @Override
            public void execute() {
                System.out.println(biblioteca.showMovieList());
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
