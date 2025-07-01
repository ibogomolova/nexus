package com.sphere.nexus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UniversityTest {

    @Test
    void addStudents() {
    }

    @Test
    void getAllStudents() {
        Student student1 = new Student("Ksu", 18, false);
        Student student2 = new Student("Kris", 22, false);
        Student student3 = new Student("Maks", 27, true);

        University university = new University();
        university.addStudents(student1);
        university.addStudents(student2);
        university.addStudents(student3);

        List<Student> expected = university.getAllStudents();
        List<Student> actual = new ArrayList<Student>();

        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        assertEquals(expected, actual);
    }

    @Test
    void testGetAllStudents() {
    }
}