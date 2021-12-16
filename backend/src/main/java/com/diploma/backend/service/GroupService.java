package com.diploma.backend.service;

import com.diploma.backend.entity.StudentGroup;

import java.util.List;

public interface GroupService {
    List<StudentGroup> findAll();
    StudentGroup findByTitle(String title);
    List<StudentGroup> findByCourse(int course);
    List<StudentGroup> findBySpecialtyId(int id);
}
