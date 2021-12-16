package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Teacher;
import com.diploma.backend.repository.TeacherRepo;
import com.diploma.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo){
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher findByFIO(String name, String surname, String middleName) {
        return teacherRepo.findByNameAndSurnameAndMiddleName(name, surname, middleName);
    }
}
