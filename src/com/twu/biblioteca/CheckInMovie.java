package com.twu.biblioteca;

import java.util.Scanner;


public class CheckInMovie {
    private final Biblioteca biblioteca;

    public CheckInMovie(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Executable invoke() {
        return new Executable() {
            @Override
            public void execute() {
                Scanner scanner = new Scanner(System.in);
                String memberId = getUserId(scanner);
                if (isValidMemberAndhasMovie(scanner, memberId)) return;
                System.out.println("“That is not a valid movie to return.”");
            }

            private boolean isValidMemberAndhasMovie(Scanner scanner, String memberId) {
                return biblioteca.findMember(memberId)!=null && returnMovie(scanner, memberId);
            }

            private boolean returnMovie(Scanner scanner, String memberId) {
                String movieName = getMovieName(scanner);
                Member member = biblioteca.findMember(memberId);
                Movie movie = biblioteca.findMovie(movieName);
                if(isValidMovieAndIsBorrowedMovieAndHasMovie(member, movie)){
                    member.returnMovie(biblioteca.findMovie(movieName));
                    System.out.println("“Thank you for returning the movie.”");
                    return true;
                }
                return false;
            }

            private String getMovieName(Scanner scanner) {
                System.out.println("Enter movie name :\t");
                return scanner.nextLine();
            }

            private boolean isValidMovieAndIsBorrowedMovieAndHasMovie(Member member, Movie movie) {
                return movie!=null && movie.isBorrowed() && member.hasMovie(movie);
            }

            private String getUserId(Scanner scanner) {
                System.out.println("Enter Id :\t");
                return scanner.nextLine();
            }
        };
    }
}
