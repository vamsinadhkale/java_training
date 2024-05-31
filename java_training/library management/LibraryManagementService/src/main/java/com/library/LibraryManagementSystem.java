package com.library;

import java.util.Scanner;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * library management system Created instances of Library, Librarian, StudentMember, and TeacherMember.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library();

        // Create a librarian
        Librarian librarian = new Librarian(library);

        // Create members
        Member student = new StudentMember("Vamsi Nadh");
        Member teacher = new TeacherMember("Sravani");

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            //new Line
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String addTitle = scanner.nextLine();
                    Book newBook = new Book(addTitle);
                    librarian.addBook(newBook);
                    System.out.println("Book added: " + addTitle);
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Book bookToRemove = findBookByTitle(library, removeTitle);
                    if (bookToRemove != null) {
                        librarian.removeBook(bookToRemove);
                        System.out.println("Book removed: " + removeTitle);
                    } else {
                        System.out.println("Book not found: " + removeTitle);
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    Book bookToIssue = findBookByTitle(library, issueTitle);
                    if (bookToIssue != null) {
                        System.out.print("Issue to (1) Student or (2) Teacher? (Selecte Number)");
                        int memberType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Member member = (memberType == 1) ? student : teacher;
                        if (library.issueBook(bookToIssue, member)) {
                            System.out.println("Book issued: " + issueTitle);
                        } else {
                            System.out.println("Cannot issue book: " + issueTitle);
                        }
                    } else {
                        System.out.println("Book not found: " + issueTitle);
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book bookToReturn = findBookByTitle(library, returnTitle);
                    if (bookToReturn != null) {
                        System.out.print("Return from (1) Student or (2) Teacher? (Selecte Number)");
                        int memberType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Member member = (memberType == 1) ? student : teacher;
                        if (library.returnBook(bookToReturn, member)) {
                            System.out.println("Book returned: " + returnTitle);
                        } else {
                            System.out.println("Cannot return book: " + returnTitle);
                        }
                    } else {
                        System.out.println("Book not found: " + returnTitle);
                    }
                    break;

                case 5:
                    System.out.println("Books in library:");
                    for (Book book : library.getBooks()) {
                        System.out.println(book.getTitle() + " - Issued: " + book.isIssued());
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Helper method to find a book by title
    private static Book findBookByTitle(Library library, String title) {
        for (Book book : library.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
