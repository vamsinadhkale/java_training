package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * Book Class.
 */
public class Book {
    private String title;
    private boolean issued;

    public Book(String title) {
        this.title = title;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}
