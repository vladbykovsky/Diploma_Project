package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Student;
import com.diploma.backend.repository.StudentRepo;
import com.diploma.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudentsByGroup(int groupId) {
        return studentRepo.getAllByStudentGroupByGroupId_Id(groupId);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student getStudentForAccount(String name, String surname, String title) {
        return studentRepo.findByNameAndSurnameAndStudentGroupByGroupId_Title(name, surname, title);
    }

}
