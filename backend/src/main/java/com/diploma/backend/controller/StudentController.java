package com.diploma.backend.controller;

import com.diploma.backend.entity.Student;
import com.diploma.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/groupId/{id}", method = RequestMethod.GET)
    public List<Student> getAllStudents(@PathVariable(name="id") int id){
        return studentService.getStudentsByGroup(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable(name="id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/name/{name}/surname/{surname}/groupTitle/{title}", method = RequestMethod.GET)
    public Student getStudentForAccount(@PathVariable(name="name") String name,
                                        @PathVariable(name="surname") String surname,
                                        @PathVariable(name="title") String title){
        return studentService.getStudentForAccount(name, surname, title);
    }
}
