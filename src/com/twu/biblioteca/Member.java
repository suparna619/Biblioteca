package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suparnad on 3/23/2015.
 */
public class Member {
    private String name;
    private String id;
    List<Book> books = new ArrayList<Book>();
    Member(String name, String id){
        this.id = id;
        this.name = name;
    }

}
