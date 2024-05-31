package com.library;

/**
 * @author Vamsi Nadh
 * 30-05-2024
 * TeacherMember class Extending Member abstract class passing name and Max Book issue size for Teacher.
 */
public class TeacherMember extends Member {
    public TeacherMember(String name) {
    	// Teachers can issue up to 5 books
        super(name, 5);
    }
}
