package com.studentManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Vamsi nadh
 * 10/06/24
 */
@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
    private StudentManager studentManager;

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        studentManager = new StudentManager();
        try {
            studentManager.loadFromFile("students.dat");
        } catch (IOException e) {
            System.out.println("No existing student data found. Starting fresh.");
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student by ID");
            System.out.println("3. Update student details by ID");
            System.out.println("4. Search for a student by ID");
            System.out.println("5. Display all students");
            System.out.println("6. Exit and save data");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    studentManager.displayAllStudents();
                    break;
                case 6:
                    try {
                        studentManager.saveToFile("students.dat");
                    } catch (IOException e) {
                        System.out.println("Failed to save data: " + e.getMessage());
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Student student = new Student(id, name, age, grade, address);
        try {
            studentManager.addStudent(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        try {
            studentManager.removeStudent(id);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();

        try {
            studentManager.updateStudent(id, name, age, grade, address);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        try {
            Student student = studentManager.searchStudent(id);
            System.out.println(student);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
