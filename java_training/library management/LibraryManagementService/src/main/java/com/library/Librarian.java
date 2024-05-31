package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * Librarian class to add and remove books from the library.
 */
public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }
}
