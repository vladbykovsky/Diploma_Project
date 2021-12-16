package com.diploma.backend.service;

import com.diploma.backend.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
    Subject findById(int id);
}
