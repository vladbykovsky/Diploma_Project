package com.diploma.backend.controller;

import com.diploma.backend.entity.StudentGroup;
import com.diploma.backend.entity.Subject;
import com.diploma.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject getSubjectById(@PathVariable(name="id") int id){
        return subjectService.findById(id);
    }
}
