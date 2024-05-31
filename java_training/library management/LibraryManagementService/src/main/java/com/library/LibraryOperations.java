package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * Interface LibraryOperations with methods for issuing and returning books
 */
public interface LibraryOperations {
    boolean issueBook(Book book, Member member);
    boolean returnBook(Book book, Member member);
}
