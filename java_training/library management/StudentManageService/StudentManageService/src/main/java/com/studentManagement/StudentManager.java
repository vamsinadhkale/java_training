package com.studentManagement;

import java.io.*;
import java.util.*;

/**
 * @author Vamsi nadh
 * 10/06/24
 */
public class StudentManager {
    private HashMap<Integer, Student> studentMap;
    private TreeSet<Student> studentSet;

    public StudentManager() {
        studentMap = new HashMap<>();
        studentSet = new TreeSet<>();
    }

    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student ID already exists");
        }
        studentMap.put(student.getId(), student);
        studentSet.add(student);
    }

    public void removeStudent(int id) {
        Student student = studentMap.remove(id);
        if (student == null) {
            throw new NoSuchElementException("Student ID not found");
        }
        studentSet.remove(student);
    }

    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student student = studentMap.get(id);
        if (student == null) {
            throw new NoSuchElementException("Student ID not found");
        }
        studentSet.remove(student);
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        student.setAddress(address);
        studentSet.add(student);
    }

    public Student searchStudent(int id) {
        Student student = studentMap.get(id);
        if (student == null) {
            throw new NoSuchElementException("Student ID not found");
        }
        return student;
    }

    public void displayAllStudents() {
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentMap = (HashMap<Integer, Student>) ois.readObject();
            studentSet = new TreeSet<>(studentMap.values());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentMap);
        }
    }
}
