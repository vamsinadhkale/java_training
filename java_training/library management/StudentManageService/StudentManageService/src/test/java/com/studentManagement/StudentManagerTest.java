package com.studentManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;


/**
 * @author Vamsi nadh
 * 11/06/24
 */
public class StudentManagerTest {
    private StudentManager studentManager;

    @BeforeEach
    public void setUp() {
        studentManager = new StudentManager();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        studentManager.addStudent(student);
        assertEquals(student, studentManager.searchStudent(1));
    }

    @Test
    public void testRemoveStudent() {
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        studentManager.addStudent(student);
        studentManager.removeStudent(1);
        assertThrows(NoSuchElementException.class, () -> studentManager.searchStudent(1));
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        studentManager.addStudent(student);
        studentManager.updateStudent(1, "Jane Doe", 21, "B", "456 Main St");
        Student updatedStudent = studentManager.searchStudent(1);
        assertEquals("Jane Doe", updatedStudent.getName());
        assertEquals(21, updatedStudent.getAge());
        assertEquals("B", updatedStudent.getGrade());
        assertEquals("456 Main St", updatedStudent.getAddress());
    }

    @Test
    public void testSearchStudent() {
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        studentManager.addStudent(student);
        assertEquals(student, studentManager.searchStudent(1));
    }

    @Test
    public void testDisplayAllStudents() {
        Student student1 = new Student(1, "John Doe", 20, "A", "123 Main St");
        Student student2 = new Student(2, "Jane Doe", 21, "B", "456 Main St");
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.displayAllStudents();
    }
}
