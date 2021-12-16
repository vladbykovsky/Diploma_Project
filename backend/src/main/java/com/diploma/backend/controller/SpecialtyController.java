package com.diploma.backend.controller;

import com.diploma.backend.entity.Specialty;
import com.diploma.backend.entity.Student;
import com.diploma.backend.entity.Teacher;
import com.diploma.backend.service.SpecialtyService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Specialty getSpecialty(@PathVariable(name="id") int id){
        return specialtyService.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Specialty> getAllSpecialties() {
        return specialtyService.finAll();
    }
}
