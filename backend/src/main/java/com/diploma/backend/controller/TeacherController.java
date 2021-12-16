package com.diploma.backend.controller;

import com.diploma.backend.entity.Teacher;
import com.diploma.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

}
