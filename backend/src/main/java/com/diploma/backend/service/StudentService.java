package com.diploma.backend.service;

import com.diploma.backend.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentsByGroup(int groupId);
    Student getStudentById(int id);
    Student getStudentForAccount(String name, String surname, String title);
}
