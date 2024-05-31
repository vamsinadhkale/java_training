package com.library;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * Library Class.
 */
public class Library implements LibraryOperations {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public boolean issueBook(Book book, Member member) {
        if (!book.isIssued() && member.canIssueMoreBooks()) {
            book.setIssued(true);
            member.issueBook();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, Member member) {
        if (book.isIssued()) {
            book.setIssued(false);
            member.returnBook();
            return true;
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}
