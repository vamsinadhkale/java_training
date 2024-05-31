package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * Member abstract class.
 */
public abstract class Member {
    private String name;
    private int maxBooksIssued;
    private int currentBooksIssued;

    public Member(String name, int maxBooksIssued) {
        this.name = name;
        this.maxBooksIssued = maxBooksIssued;
        this.currentBooksIssued = 0;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooksIssued() {
        return maxBooksIssued;
    }

    public int getCurrentBooksIssued() {
        return currentBooksIssued;
    }

    public boolean canIssueMoreBooks() {
        return currentBooksIssued < maxBooksIssued;
    }

    public void issueBook() {
        if (canIssueMoreBooks()) {
            currentBooksIssued++;
        }
    }

    public void returnBook() {
        if (currentBooksIssued > 0) {
            currentBooksIssued--;
        }
    }
}
