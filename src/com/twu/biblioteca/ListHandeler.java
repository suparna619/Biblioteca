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
        commands.put("check_out", new CheckOut(biblioteca).invoke());
        commands.put("check_in", new CheckIn(biblioteca).invoke());
    }

    public void executeCommand(String userChoice) {
        commands.get(userChoice).execute();
    }

}
