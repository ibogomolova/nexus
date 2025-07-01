package com.sphere.nexus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

    private Map<Integer, Student> allStudent = new HashMap<>();
    private int countId = 1;

    public void addStudents(Student student) {
        if (student == null) {
            return;
        }
        student.setId(countId);
        allStudent.put(countId, student);
        countId++;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(allStudent.values());
    }

    public List<Student> getAllStudents(boolean isMale) {
        List<Student> listAllStudent = new ArrayList<>();
        for (Student student : allStudent.values()) {
            if (student.isMale() == isMale) {
                listAllStudent.add(student);
            }
        }
        return listAllStudent;
    }
}
