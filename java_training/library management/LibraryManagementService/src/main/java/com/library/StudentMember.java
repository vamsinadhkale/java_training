package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * StudentMember class Extending Member abstract class passing name and Max Book issue size for Student.
 */
public class StudentMember extends Member {
    public StudentMember(String name) {
    	// Students can issue up to 3 books
        super(name, 3);
    }
}
