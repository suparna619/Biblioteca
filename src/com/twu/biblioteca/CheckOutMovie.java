package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by suparnad on 3/25/2015.
 */
public class CheckOutMovie {
    private Biblioteca biblioteca;

    public CheckOutMovie(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Executable invoke() {
        return new Executable() {
            @Override
            public void execute() {
                Scanner scanner = new Scanner(System.in);
                String memberId = getUserId(scanner);
                if (ifValidMemberAndMovieBorrower(scanner, memberId)) return;
                System.out.println("“That movie is not available”");
            }

            private boolean ifValidMemberAndMovieBorrower(Scanner scanner, String memberId) {
                return biblioteca.findMember(memberId)!=null && borrowMovie(scanner, memberId);
            }

            private boolean borrowMovie(Scanner scanner, String memberId) {
                String movieName = getMovieName(scanner);
                Movie movie = biblioteca.findMovie(movieName);
                if(ifValidMovieAndIsBorrowed(movie)){
                    biblioteca.allotMovie(movieName, memberId);
                    System.out.println("“Thank you! Enjoy the Movie”");
                    return true;
                }
                return false;
            }

            private boolean ifValidMovieAndIsBorrowed(Movie movie) {
                return movie!=null && !movie.isBorrowed();
            }

            private String getMovieName(Scanner scanner) {
                System.out.println("Enter Movie name :\t");
                return scanner.nextLine();
            }

            private String getUserId(Scanner scanner) {
                System.out.println("Enter Id :\t");
                return scanner.nextLine();
            }
        };
    }
}