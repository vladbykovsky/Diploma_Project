package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Subject;
import com.diploma.backend.repository.SubjectRepo;
import com.diploma.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    public SubjectServiceImpl(SubjectRepo subjectRepo){
        this.subjectRepo = subjectRepo;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject findById(int id) {
        return this.subjectRepo.findById(id);
    }
}
