package com.diploma.backend.service;

import com.diploma.backend.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findByFIO(String name, String surname, String middleName);
}
